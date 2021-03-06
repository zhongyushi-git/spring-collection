package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//此注解表示此类是一个配置类，可代替xml配置文件
@Configuration
//开启注解进行包扫描
@ComponentScan(basePackages = {"com.test"})
public class SpringConfig {
}
