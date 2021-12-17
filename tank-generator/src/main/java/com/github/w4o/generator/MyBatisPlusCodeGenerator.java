package com.github.w4o.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author frank
 * @date 2021/12/17
 */
public class MyBatisPlusCodeGenerator {
    private final static String PROJECT_PATH = System.getProperty("user.dir");
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/tank_db?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "123456";

    private final static String MODULE_NAME = "manage";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        FastAutoGenerator.create(DB_URL, DB_USER, DB_PASSWORD)
                .globalConfig(builder -> builder.author("Auto Generate").disableOpenDir())
                .packageConfig(builder -> {
                    Map<OutputFile, String> pathInfo = new HashMap<>(3);
                    pathInfo.put(OutputFile.mapper, PROJECT_PATH + File.separator + "tank-" + MODULE_NAME + File.separator + "src/main/java/com/github/w4o/tank/" + MODULE_NAME + "/mapper");
                    pathInfo.put(OutputFile.mapperXml, PROJECT_PATH + File.separator + "tank-" + MODULE_NAME + File.separator + "src/main/resources/mapper");
                    pathInfo.put(OutputFile.entity, PROJECT_PATH + File.separator + "tank-core" + File.separator + "src/main/java/com/github/w4o/tank/core/entity");
                    // 设置父包名
                    builder.parent("com.github.w4o.tank")
                            // 设置父包模块名
                            // .moduleName(MODULE_NAME)
                            .entity("core.entity")
                            .mapper(MODULE_NAME + ".mapper")
                            // 设置mapperXml生成路径
                            .pathInfo(pathInfo);
                })
                .templateConfig(builder -> builder.disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICEIMPL))
                .strategyConfig(builder -> builder
                        // 设置需要生成的表名
                        .addInclude(scanner("表名，多个英文逗号分割").split(","))
                        .entityBuilder()
                        .superClass("com.github.w4o.tank.core.base.BaseSysEntity")
                        .enableLombok()
                        .addSuperEntityColumns("deleted", "create_by", "create_time", "update_by", "update_time", "id", "version")
                        .formatFileName("%sEntity"))

                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
