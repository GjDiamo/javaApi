package com.contrat.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <p>应用启动类，启动时运行mian方法即可</p>
 *
 * <p>需要添加其他额外的依赖要在pom.xml中引用其他包的maven依赖</p>
 *
 * <p>需要配置端口、整个应用的其他配置项就在application.properties文件中配置</p>
 *
 */
@SpringBootApplication

public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
