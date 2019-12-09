# Mybatis-Plus 动态数据源

## 使用方法

1.引入dynamic-datasource-spring-boot-starter

```xml
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
  <version>最新版本</version>
</dependency>
```



2.配置数据源

```yml
spring:
  datasource:
    dynamic:
      primary: master #设置默认的数据源或者数据源组,默认值即为master
      datasource:
        master:
          username: root
          password: 123456
          driver-class-name: com.mysql.jdbc.Driver
          url: jdbc:mysql://xx.xx.xx.xx:3306/dynamic
        slave_1:
          username: root
          password: 123456
          driver-class-name: com.mysql.jdbc.Driver
          url: jdbc:mysql://xx.xx.xx.xx:3307/dynamic
        slave_2:
          username: root
          password: 123456
          driver-class-name: com.mysql.jdbc.Driver
          url: jdbc:mysql://xx.xx.xx.xx:3308/dynamic
       #......省略
       #以上会配置一个默认库master，一个组slave下有两个子库slave_1,slave_2
```



```yml
#纯粹多库(记得设置primary)
spring:
	datasource:
		dynamic: 
			datasource:
				mysql:
				oracle:
				sqlserver:
				postgresql:
				h2:

#混合配置
spring：
	datasource：
		dynamic:
			datasource:
				master:
					user:
					password:
					url:
					driver-class-name:
				slave_1:
					... ...
				slave_2:
					... ...
				oracle_1:
					... ...
				oracle_2:
					... ...
					
# 多主多从
spring:
	datasource:
		dynamic:
			datasource:
				master_1:
				master_2:
				slave_1:
				slave_2:
				slave_3:
					
				
```



3.使用`@DS`切换数据源

`@DS`可以注解在方法上和类上，**同时存在方法注解优先于类上注解**。

注解在service实现或mapper接口方法上，但强烈不建议同时在service和mapper上进行注解。

| 注解          | 结果                                     |
| ------------- | ---------------------------------------- |
| 没有@DS       | 默认数据源                               |
| @DS("dsName") | dsName可以为组名也可以为具体某个库的名称 |



```java
@Service
@DS("slave")
public class UserServiceImpl implements UserService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Map<String, Object>> selectAll() {
    return  jdbcTemplate.queryForList("select * from user");
  }
  
  @Override
  @DS("slave_1")
  public List<Map<String, Object>> selectByCondition() {
    return  jdbcTemplate.queryForList("select * from user where age >10");
  }
}
```

在mybatis环境下也可以注解在mapper接口层

```java
@DS("slave")
public interface UserMapper {

  @Insert("INSERT INTO user (name,age) values (#{name},#{age})")
  boolean addUser(@Param("name") String name, @Param("age") Integer age);

  @Update("UPDATE user set name=#{name}, age=#{age} where id =#{id}")
  boolean updateUser(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

  @Delete("DELETE from user where id =#{id}")
  boolean deleteUser(@Param("id") Integer id);

  @Select("SELECT * FROM user")
  @DS("slave_1")
  List<User> selectAll();
}
```

























