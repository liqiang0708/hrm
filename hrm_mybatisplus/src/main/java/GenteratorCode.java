import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * Created by CDHong on 2018/4/6.
 */
public class GenteratorCode {

    public static void main(String[] args) throws InterruptedException {
        //用来获取Mybatis-Plus.properties文件的配置信息
        ResourceBundle rb = ResourceBundle.getBundle("MyBatisPlus-System"); //不要加后缀==============================
        //ResourceBundle rb = ResourceBundle.getBundle("MyBatisPlus-Course"); //不要加后缀
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rb.getString("OutputDir"));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(rb.getString("author"));
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        //dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDriverName(rb.getString("jdbc.driver"));
        dsc.setUsername(rb.getString("jdbc.user"));
        dsc.setPassword(rb.getString("jdbc.pwd"));
        dsc.setUrl(rb.getString("jdbc.url"));
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"t_department", "t_employee","t_meal","t_menu", "t_permission","t_role","t_tenant","t_tenant_type"}); // 需要生成的表===========================================
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(rb.getString("parent"));
        pc.setController("web.controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("domain");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        //============================================第一种方式========================================================
        // 调整 domain 生成目录演示 生成到接口
       /* focList.add(new FileOutConfig("/templates/Swagger2.java.vm") {//只需要生成一次就够了
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDir")+ "/com/liqiang/hrm/config/Swagger2.java";
            }
        });*/

        // 调整 client  clientFactory 生成目录演示 生成到接口
        focList.add(new FileOutConfig("/templates/client.java.vm") {//这个模板在templates找不到，是框架内置的
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ApiOutputDirBase")+ "/com/liqiang/hrm/client/" + tableInfo.getEntityName() + "Client.java";
            }
        });
        // 调整 client  clientFactory 生成目录演示 生成到接口
        focList.add(new FileOutConfig("/templates/ClientHystrixFallbackFactory.java.vm") {//这个模板在templates找不到，是框架内置的
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ApiOutputDirBase")+ "/com/liqiang/hrm/client/" + tableInfo.getEntityName() + "ClientHystrixFallbackFactory.java";
            }
        });
        // 调整 domain 生成目录演示 生成到接口
        focList.add(new FileOutConfig("/templates/entity.java.vm") {//这个模板在templates找不到，是框架内置的
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ApiOutputDirBase")+ "/com/liqiang/hrm/domain/" + tableInfo.getEntityName() + ".java";
            }
        });
        // 调整 query 生成目录演示 生成到接口
        focList.add(new FileOutConfig("/templates/query.java.vm") {//完全自己写的
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ApiOutputDirBase")+ "/com/liqiang/hrm/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });
        // 调整 controller 生成目录演示 生成到service
        focList.add(new FileOutConfig("/templates/controller.java.vm") {//controller模板也有内置。但这里自定义了
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDir")+ "/com/liqiang/hrm/web/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {//内置的
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDirXml")+ "/com/liqiang/hrm/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        //============================================第二种方式========================================================
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity(null);
        tc.setMapper("/templates/mapper.java.vm");
        tc.setController(null);
        tc.setXml(null);
        // 如上任何一个模块如果设置 空 OR Null 将不通过此方式生成该模块。
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}
