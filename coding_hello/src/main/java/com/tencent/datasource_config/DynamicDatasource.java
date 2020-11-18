package com.tencent.datasource_config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源及数据源选择器
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    //切换数据源的核心方法，返回当前需要切换的数据源的标识
    @Override
    protected Object determineCurrentLookupKey() {
        return threadLocal.get();
    }

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setLocal(String keyword){
        threadLocal.set(keyword);
    }
}
