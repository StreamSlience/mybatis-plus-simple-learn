## 分页插件
[**mpsl-page**](https://gitee.com/StreamSlience/mybatis-plus-simple-learn/tree/feature-1.0.0/StreamSlience/mpsl-page)
### 添加MybatisPlus配置类

```java
@EnableTransactionManagement
@Configuration
@MapperScan("com.baomidou.cloud.service.*.mapper*")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }
}
```

> **注意**：以上配置方式是用在`SpringBoot`项目中，任意适当位置创建该配置类即可。如果不进行该配置，则分业功能将不能正常使用。



### MP自带分页查询方法

```java
/**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
    * @param queryWrapper 实体对象封装操作类（可以为 null）
    */
IPage<T> selectPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

/**
    * 根据 Wrapper 条件，查询全部记录（并翻页）
    *
    * @param page         分页查询条件
    * @param queryWrapper 实体对象封装操作类
    */
IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
```



### xml自定义分页

#### 持久层接口

```java
@Repository
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

    IPage<UserInfoEntity> getUserInfoList(Page page);
    
    IPage<UserInfoEntity> findUserInfoList(Page page, @Param("qry") UserInfoQry qry);
    
}
```

> **注意点**：
>
> - 持久层接口可以不用继承`BaseMapper<T>`，自行编写分页查询方法。
>
> - 持久层返回参数需要使用`IPage<T>`进行接收
> - 实现分业必须添加分业参数`Page page`，同时必须放在参数签名的其实位置，如果有多参数则需要使用`@Param`注解指定参数名称
> - 当total小于0或者设置setSearchCount(false)分页插件不会进行count查询

#### xml文件

```xml
<select id="getUserInfoList" resultType="com.example.demo.entity.UserInfoEntity">
    SELECT * FROM user_info
</select>

<select id="findUserInfoList" resultType="com.example.demo.entity.UserInfoEntity">
    SELECT * FROM user_info 
    <where>
    	<if test="qry.userName != null and qry.userName != ''">
        	user_name LIKE CONCAT('%',#{qry.userName},'%')
        </if>
    </where>
</select>
```

> **注意**：
>
> - Sql语句的编写等同于一个普通查询的编写
> - Sql语句结尾不能添加分号`;`因为分页插件直接将分页操作拼接在了Sql语句末尾,以上xml中的Sql语句最终效果为`SELECT * FROM user_info LIMIT ?,?`





