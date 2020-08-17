package com.yan01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.yan01")
@EnableTransactionManagement
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringTxConfiguration {

}
