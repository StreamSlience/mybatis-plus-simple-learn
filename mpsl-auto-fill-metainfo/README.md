# Mybatis-Plus 字段自动填充

## 应用场景

​	日常开发过程中，有一些字段是属于每张数据库表的公有字段，并且在进行新增和修改操作时都需要进行修改，通过`Mybatis-Plus`的字段自动填充功能可以自动实现这些字段的赋值，可以在业务层中减少一定的代码重复量。



## 应用示例

### 1.抽离数据库表公有字段

​	将数据库表中的共公有字段抽离成一个抽象类：

```java
@Getter
@Setter
public abstract class BaseEntity<T extends Model> extends Model {

    private String createId;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    private String updateId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    @TableLogic(value = "A", delval = "D")
    private String deleted = "A";
}
```

> **注**：需要实现自动填充的字段必须声明注解`@TableField`,属性`fill`选择对应策略，该申明告知`Mybatis-Plus`需要预留注入`SQL`字段

​	下面是自动填充策略枚举类`FieldFill`的源码：

```java
/**
 * 字段填充策略枚举类
 *
 * <p>
 * 判断注入的 insert 和 update 的 sql 脚本是否在对应情况下忽略掉字段的 if 标签生成
 * <if test="...">......</if>
 * 判断优先级比 {@link FieldStrategy} 高
 * </p>
 *
 * @author hubin
 * @since 2017-06-27
 */
public enum FieldFill {
    /*默认不处理*/
    DEFAULT,
    /* 插入时填充字段*/
    INSERT,
    /*更新时填充字段*/
    UPDATE,
    /*插入和更新时填充字段*/
    INSERT_UPDATE
}
```



### 2.实体类继承超类

```java
@Data
@TableName("xx_goods")
@NoArgsConstructor
public class GoodsEntity extends BaseEntity<GoodsEntity> {

    @TableId(type = IdType.UUID)
    private String goodsId;

    private String goodsName;

    public GoodsEntity(String goodsName) {
        this.goodsName = goodsName;
    }
}
```

具体的表结构如下：

```sql
-- ----------------------------
-- Table structure for xx_goods
-- ----------------------------
DROP TABLE IF EXISTS `xx_goods`;
CREATE TABLE `xx_goods` (
  `goods_id` varchar(32) NOT NULL DEFAULT '' COMMENT '物料主键',
  `goods_name` varchar(32) NOT NULL COMMENT '物料名称',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者主键',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '修改者主键',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` varchar(1) DEFAULT NULL COMMENT '逻辑删除标识',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料信息表';
```



### 3.自定义实现类自动填充处理类

​	自定义`MyMetaObjectHandler`字段自动填充处理类实现`MetaObjectHandler`接口

> **注**：在SpringBoot中需要添加注解`@Component`进行注入

```java
/**
 * <h2>Title:自定义字段注入处理类</h2><br>
 * <h2>Description:</h2><br>
 * 对于实现自动注入的字段，前端不需要传值，<br>
 * 任何显示的赋值都将使自动注入失效，取而代之的值即为显示赋值的参数。<br>
 *
 * @author StreamSlience
 * @Date 2019/11/30-20:53
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * <p>新增自动注入</p>
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createDate") && metaObject.hasGetter("updateDate")) {
            this.setFieldValByName("createDate", new Date(), metaObject);
            this.setFieldValByName("updateDate", new Date(), metaObject);
        }
    }

    /**
     * <p>更新自动注入</p>
     *
     * @param metaObject
     * @note mybatisPlus自带的update方法都对入参实体添加了注解@Param("et")<br>
     * 因此使用{@code metaObject.hasGetter("updateDate")} 为 false
     * 应该使用{@code metaObject.hasGetter("et.updateDate")}或
     * {@code metaObject.hasGetter("param1.updateDate")}才是正确方法
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("et.updateDate")) {
            this.setFieldValByName("updateDate", new Date(), metaObject);
        }
    }
}
```

> **注**：
>
> **1.更新操作时使用`et.XXX`或`param1.XXX`**
>
> ​	复写新增和更新自动注入方法时通常需要使用`metaObject.hasGetter("")`方法进行判断字段是否存在。
>
> 需要注意的是更新时必须使用`et.XXX`或`param1.XXX`才能正确判断`xxx`字段是否存在(`xxx`对应实体类中的字段名，而非数据库中的字段名)。
>
> ​	下面通过Debug调试下查看`metaObject`对象：
>
> 新增
>
> ![输入图片说明](https://images.gitee.com/uploads/images/2019/1201/193342_4a9a888d_4852186.png "001_新增自动填充.png")
>
> 修改
>
> ![输入图片说明](https://images.gitee.com/uploads/images/2019/1201/193353_c2298682_4852186.png "002_修改自动填充.png")
>
> 再看`BaseMapper`中的源码
>
> ```java
> /**
>   * 插入一条记录
>   *
>   * @param entity 实体对象
>   */
> int insert(T entity);
> 
> /**
>   * 根据 ID 修改
>   *
>   * @param entity 实体对象
>   */
> int updateById(@Param(Constants.ENTITY) T entity);
> /**
>   * 根据 whereEntity 条件，更新记录
>   *
>   * @param entity        实体对象 (set 条件值,可以为 null)
>   * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
>   */
> int update(@Param(Constants.ENTITY) T entity, @Param(Constants.WRAPPER) Wrapper<T> updateWrapper);
> ```
>
> 其中`Constants.Entity`对应`Constants`接口中的字符串常量**et**
>
> 修改时的`metaObject`对象中的`param1`和`et`是同一个表示实体类的对象，而`param2`和`ew`表示修改查询条件。
>
> 



### 4.测试类实现

```java
@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class GoodsAutoFillMetainfoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    @Order(1)
    public void insert() {
        goodsDao.insert(new GoodsEntity("我是一个物料新增"));
    }

    @Test
    @Order(2)
    public void update() {
        goodsDao.update(new GoodsEntity("我是一个物料修改"), new LambdaUpdateChainWrapper<>(goodsDao).eq(GoodsEntity::getGoodsName, "我是一个物料新增").getWrapper());
    }

    @Test
    @Order(3)
    public void delete() {
        goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
    }
}
```
>**注**：自动填充是在执行完插入或更新方法之后，即`Mybatis-Plus`会在方法之后判断`@TableField`注解的字段是否有显示赋值，如果没有才会通过自定义填充实现类`MyMetaObjectHandler`。 


