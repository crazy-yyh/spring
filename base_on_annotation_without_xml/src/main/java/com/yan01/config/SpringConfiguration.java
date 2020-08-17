package com.yan01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.yan01")
@Import(JdbcConfig.class)
@PropertySource("classpath:Jdbc.properties")
public class SpringConfiguration {


}
//注意：
//    properties文件还与配置没有联系，那怎么关联呢
//    请看下一个注解

