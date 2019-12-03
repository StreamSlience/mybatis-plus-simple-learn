# Mybaits-Plus 性能分析插件 与 SQL分析打印

**[mybatis-plus-simple-learn](https://gitee.com/StreamSlience/mybatis-plus-simple-learn/tree/feature-1.0.0/StreamSlience/mpsl-crud)**

## ~~性能分析插件~~



性能分析拦截器用户输出每条SQL语句及其执行时间

该插件 `3.2.0` 以上版本移除推荐使用第三方扩展 [执行SQL分析打印](https://mybatis.plus/guide/p6spy) 功能



使用如下：

MVC方式

```xml
<plugins>
    <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->
    <plugin interceptor="com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor">
        <property name="maxTime" value="100" />
        <!--SQL是否格式化 默认false-->
        <property name="format" value="true" />
    </plugin>
</plugins>
```

SpringBoot方式

```java
@EnableTransactionManagement
@Configuration
@MapperScan("com.streamslience.simples.crud.mpslcrud.dao.*")
public class MybatisPlusConfig {

    /**
     * SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
}
```

> 注意：
>
> 参数说明
>
> 参数maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
>
> 参数format SQL SQL是否格式化，默认false。
>
> 该插件只用于开发环境，不建议生产环境使用。





## SQL分析打印

- p6spy 依赖引入

Maven：

```xml
<dependency>
  <groupId>p6spy</groupId>
  <artifactId>p6spy</artifactId>
  <version>最新版本</version>
</dependency>
```

Gradle：

```groovy
compile group: 'p6spy', name: 'p6spy', version: '最新版本'
```

- application.yml 配置：

```xml
spring:
  datasource:
    driver-class-name: com.p6spy.engine.spy.P6SpyDriver
    url: jdbc:p6spy:h2:mem:test
    ...
```

例如：`jdbc:p6spy:mysql://localhost:3306/mybatispuls?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`

p6spy必须添加，不然p6spy不能拦截



- spy.properties 配置：

```properties
#3.2.1以上使用
#module.log=com.baomidou.mybatisplus.extension.p6spy.MybatisPlusLogFactory
#3.2.1以下使用或者不配置
module.log=com.p6spy.engine.logging.P6LogFactory,com.p6spy.engine.outage.P6OutageFactory
# 自定义日志打印
logMessageFormat=com.baomidou.mybatisplus.extension.p6spy.P6SpyLogger
#日志输出到控制台
appender=com.baomidou.mybatisplus.extension.p6spy.StdoutLogger
# 使用日志系统记录 sql
#appender=com.p6spy.engine.spy.appender.Slf4JLogger
# 设置 p6spy driver 代理
deregisterdrivers=true
# 取消JDBC URL前缀
useprefix=true
# 配置记录 Log 例外,可去掉的结果集有error,info,batch,debug,statement,commit,rollback,result,resultset.
excludecategories=info,debug,result,commit,resultset
# 日期格式
dateformat=yyyy-MM-dd HH:mm:ss
# 实际驱动可多个
#driverlist=org.h2.Driver
# 是否开启慢SQL记录
outagedetection=true
# 慢SQL记录标准 2 秒
outagedetectioninterval=2
```

> **注意**：
>
> - driver-class-name 为 p6spy 提供的驱动类
> - url 前缀为 jdbc:p6spy: 跟着冒号为对应数据库连接地址
> - 打印出sql为null,在excludecategories增加commit
> - 批量操作不打印sql,去除excludecategories中的batch
> - 批量操作打印重复的问题请使用MybatisPlusLogFactory (3.2.1新增）
> - 该插件有性能损耗，不建议在生产环境中使用
>



- 测试类打印输出

测试类方法

```java
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class MpslCrudApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void aInsert() {
        UserEntity user = new UserEntity();
        user.setUserName("我是一个用户");
        user.setUserAge(999);
        userDao.insert(user);
    }

    @Test
    public void bUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("我是一个真用户");
        userDao.update(userEntity, new LambdaQueryChainWrapper<>(userDao)
                .eq(UserEntity::getUserName, "我是一个用户").getWrapper());
    }
}
```



控制台打印

```c
//--- ---
JDBC Connection [HikariProxyConnection@2062780238 wrapping com.p6spy.engine.wrapper.ConnectionWrapper@5a8816cc] will not be managed by Spring
==>  Preparing: UPDATE xx_user SET user_name=? WHERE (user_name = ?) 
==> Parameters: 我是一个真用户(String), 我是一个用户(String)
2019//12-03 10:28:55|13|statement|connection 0|url jdbc:p6spy:mysql://localhost:3306/mybatispuls?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC|UPDATE xx_user  SET user_name=?      WHERE (user_name = ?)|UPDATE xx_user  SET user_name='我是一个真用户'      WHERE (user_name = '我是一个用户')
<==    Updates: 15
//--- ---
```

