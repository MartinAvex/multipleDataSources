package com.xavier.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @ClassName: DynamicDataSourceConfig
 * @Author: Xavier
 * @CreateTime: 2022-06-22  15:19
 * @Description: 引入动态数据源，构建数据源
 */
@Configuration
@Component
public class DynamicDataSourceConfig {

    /**
     * 读取application.xml配置, 构建master-db数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master-db")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 读取application.xml配置, 构建slave-db数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave-db")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        HashMap<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master-db", masterDataSource);
        targetDataSources.put("slave-db", slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

}
