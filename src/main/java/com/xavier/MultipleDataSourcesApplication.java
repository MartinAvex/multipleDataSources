package com.xavier;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //不加在默认的数据源配置
@MapperScan(basePackages = "com.xavier.mapper")
public class MultipleDataSourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourcesApplication.class, args);
    }

}
