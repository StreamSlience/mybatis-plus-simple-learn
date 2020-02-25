package com.streamslience.simples.generator.mpslgenerator;

import cn.hutool.extra.template.engine.velocity.VelocityTemplate;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.streamslience.simples.generator.mpslgenerator.entity.BaseEntity;

import java.sql.Driver;
import java.util.*;

/**
 * @author StreamSlience
 * @description MybatisPlus代码生成器
 * @creatdate 2019-12-10 10:17
 */
public class MybatisPlusGenerator {

    //表名-包含
    private static final String[] INCLUDE_TABLES_NAME = {};
    //表名-排除
    private static final String[] EXCLUDE_TABLES_NAME = {};
    //表名前缀
    private static final String[] TABLE_PREFIX = {};

    /*数据库配置*/
    private static final Class DRIVER_NAME = Driver.class;//数据库驱动
    private static final DbType DB_TYPE = DbType.MYSQL;//数据库类型
    private static final String URL = "jdbc:mysql://***?useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&allowMultiQueries=true&useServerPrepStmts=false&useCompression=true&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull&connectTimeout=2000&autoReconnect=true&useSSL=false";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    /*全局配置*/
    //System.getPropertu("user.dir") D:\DataRepositories\Work\IDEAWorkSpace\mybaits-plus-simple-learn\mpsl=generator
    private static final String OUTPUT_DIR = System.getProperty("user.dir") + "/mpsl-generator/src/main/java";//生成文件的输出目录
    private static final String AUTHOR_NAME = "StreamSlience";//作者名称
    private static final String ENTITY_NAME_FORMAT = "%sEntity";//实体类格式化命名
    private static final String MAPPER_NAME_FORMAT = "I%sDao";//持久层接口格式化命名
    private static final String XML_NAME_FORMAT = "%sMapper";//持久层映射文件格式化命名
    private static final String SERVICE_NAME_FORMAT = "%sService";//业务层实现类格式化命名
    private static final String SERVICE_IMPL_NAME_FORMAT = "%sServiceImpl";//业务层接口格式化命名
    private static final String CONTROLLER_NAME_FORMAT = "%sController";//控制层实现类格式化命名

    /*包配置*/
    private static final String BASE_PACKAGE = "com.streamslience.simples.generator.mpslgenerator";
    private static final String CONTROLLER_PACKAGE = "controller";
    private static final String ENTITY_PACKAGE = "entity";
    private static final String MAPPER_PACKAGE = "dao";
    private static final String XML_PACKAGE = "mapper";
    private static final String SERVICE_PACKAGE = "service";
    private static final String SERVICE_IMPL_PACKAGE = "service.impl";

    /*策略配置*/
    private static final NamingStrategy NAMING_STRATEGY = NamingStrategy.underline_to_camel;//表名命名策略(下划线转驼峰命名)
    private static final Class SUPER_ENTITY_CLASS = BaseEntity.class;//实体类超类

    public static void main(String[] args) {
        /*代码生成器*/
        AutoGenerator autoGenerator = new AutoGenerator();

        /*全局配置*/
        GlobalConfig gConfig = new GlobalConfig()
                .setOutputDir(OUTPUT_DIR)//生成文件的输出目录
                .setFileOverride(true)//覆盖已有文件
                .setSwagger2(true)//开启实体Swagger注解
                .setActiveRecord(true)//开启 ActiveRecord 模式
                .setEnableCache(true)//在xml中添加二级缓存配置
                .setBaseResultMap(true)//开启 BaseResultMap
                .setBaseColumnList(true)//开启 baseColumnList
                .setOpen(true)//打开输出目录
                .setAuthor(AUTHOR_NAME)//作者名称
                .setEntityName(ENTITY_NAME_FORMAT)//实体类名称
                .setMapperName(MAPPER_NAME_FORMAT)//持久层接口名称
                .setXmlName(XML_NAME_FORMAT)//持久岑映射文件名称
                .setServiceName(SERVICE_NAME_FORMAT)//业务层实现类名称
                .setServiceImplName(SERVICE_IMPL_NAME_FORMAT)//业务层接口名称
                .setControllerName(CONTROLLER_NAME_FORMAT);//控制层实现类名称
        autoGenerator.setGlobalConfig(gConfig);

        /*数据源配置*/
        DataSourceConfig dSConfig = new DataSourceConfig()
                .setDriverName(DRIVER_NAME.getName())//数据库驱动
                .setDbType(DbType.MYSQL)//数据库类型
                .setUrl(URL)
                .setUsername(USER_NAME)
                .setPassword(PASSWORD);
        autoGenerator.setDataSource(dSConfig);

        /*包配置*/
        PackageConfig pConfig = new PackageConfig()
                .setParent(BASE_PACKAGE)//父包名
                .setController(CONTROLLER_PACKAGE)//控制层包名
                .setEntity(ENTITY_PACKAGE)//实体类包名
                .setMapper(MAPPER_PACKAGE)//持久层接口包名
                .setXml(XML_PACKAGE)//持久层映射文件包名
                .setService(SERVICE_PACKAGE)//业务层接口包名
                .setServiceImpl(SERVICE_IMPL_PACKAGE);//业务层实现类包名
        autoGenerator.setPackageInfo(pConfig);

        /*自定义配置*/
//        InjectionConfig iConfig_1 = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        InjectionConfig iConfig_2 = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("iConfig_2", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//        //自定义文件输出位置(非必须)
//        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
//        fileOutConfigs.add(new FileOutConfig() {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return null;
//            }
//        });
//        iConfig_2.setFileOutConfigList(fileOutConfigs);
//        autoGenerator.setCfg(iConfig_2);

        /*配置模板*/
        //TemplateConfig tConfig = new TemplateConfig();
        //配置自定义输出模板
        //自定义模板路径，注意不要带上.ftl/.vm，会根据使用的模板引擎自动识别
        //tConfig.setEntity("templates/entity2.java");
        //tConfig.setService("templates/service2.java");
        //tConfig.setController("templates/controller2.java");

        //tConfig.setXml(null);
        //autoGenerator.setTemplate(tConfig);

        /*策略配置*/
        StrategyConfig sConfig = new StrategyConfig()
                .setTablePrefix(TABLE_PREFIX)//表名前缀
                .setNaming(NAMING_STRATEGY)//表名策略配置
                .setColumnNaming(NAMING_STRATEGY)//列名字段配置
                //.setInclude(INCLUDE_TABLES_NAME)//表-包含
                .setExclude(EXCLUDE_TABLES_NAME)//表-排除
                .setSuperEntityClass(SUPER_ENTITY_CLASS)//实体类超类
                //.setSuperControllerClass(null)//控制层公共超类
                //.setEntityLombokModel(true)//开启Lombok注解
                //.setEntityBuilderModel(false)//设置为true则实体类set方法返回实体对象
                .setRestControllerStyle(true)//生成 @RestController 控制器
                //.setEntitySerialVersionUID(false)//不生成持久化标识
                .setSkipView(true)//跳过视图
                .setEntityTableFieldAnnotationEnable(true);//生成实体时，生成字段注解
        autoGenerator.setStrategy(sConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        //autoGenerator.setTemplateEngine(new BeetlTemplateEngine());
        //autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
        autoGenerator.execute();
    }
}
