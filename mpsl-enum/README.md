# Mybatis-Plus 通用枚举

> 自`3.1.0`开始,可配置默认枚举处理类来省略扫描通用枚举配置 [默认枚举配置](https://mybatis.plus/config/#defaultEnumTypeHandler)
>
> - 升级说明:
>
>   `3.1.0` 以下版本改变了原生默认行为,升级时请将默认枚举设置为`EnumOrdinalTypeHandler`
>
> - 影响用户:
>
>   实体中使用原生枚举
>
> - 其他说明:
>
>   配置枚举包扫描的时候能提前注册使用注解枚举的缓存
>
> - 推荐配置:
>
>   - 使用实现`IEnum`接口
>     - 推荐配置`defaultEnumTypeHandler`
>   - 使用注解枚举处理
>     - 推荐配置`typeEnumsPackage`
>   - 注解枚举处理与`IEnum`接口
>     - 推荐配置`typeEnumsPackage`
>   - 与原生枚举混用
>     - 需配置`defaultEnumTypeHandler`与 `typeEnumsPackage`



### 1、申明通用 枚举属性

方式一：使用`@EnumValue`主键枚举属性

```java
public enum GradeEnum {
    PRIMARY(1, "小学"),  SECONDORY(2, "中学"),  HIGH(3, "高中");
    GradeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }
    @EnumValue//标记数据库存的值是code
    private final int code;
    //...
}
```

方式二：枚举属性，实现`IEnumj`接口

```java
public enum AgeEnum implements IEnum<Integer> {
    ONE(1, "一岁"),
    TWO(2, "二岁"),
    THREE(3, "三岁");
    private int value;
    private String desc;
    @Override
    public Integer getValue() {
        return this.value;
    }
}
```



### 2、配置扫描通用枚举

配置文件  resources/application.yml 

```yml
mybatis-plus:
    # 支持统配符 * 或者 ; 分割
    typeEnumsPackage: com.baomidou.springboot.entity.enums
  ....
```



### 3、JSON序列化处理

一、**Jackson**

在需要响应描述字段的get方法上添加`@JsonValue`注解即可

二、**Fastjson**

1.**全局处理方式**

```java
FastJsonConfig config = new FastJsonConfig();
//设置WriteEnumUsingToString
config.setSerializerFeatures(SerializerFeature.WriteEnumUsingToString);
converter.setFastJsonConfig(config);
```

2.**局部处理方式**

```java
@JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
private UserStatus status;
```

以上两种方式任选一种，然后在枚举中复写toString方法即可

3.**JavaBean方式序列化枚举**

无需重写toString方法

```java
@JSONType(serializeEnumAsJavaBean = true)
public enum GradeEnum {
	//... ...
}
```



































































