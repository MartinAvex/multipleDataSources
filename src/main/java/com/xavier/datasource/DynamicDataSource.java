package com.xavier.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName: DynamicDataSource
 * @Author: Xavier
 * @CreateTime: 2022-06-22  14:58
 * @Description: 设置动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    //通过ThreadLocal维护一个全局唯一的map来实现数据源的动态切换
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    /**
     * 指定数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    /**
     * 设置数据源
     */
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    /**
     * 获取数据源
     */
    public static String getDataSource() {
        return contextHolder.get();
    }

    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }

}
