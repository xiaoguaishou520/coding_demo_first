package com.tencent.datasource_config;

import com.tencent.datasource.Studb1Datasource;
import com.tencent.datasource.Studb2Datasource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.*;

@Configuration
public class MyBatisConfig {

    @Autowired
    private Studb1Datasource studb1Datasource;

    @Autowired
    private Studb2Datasource studb2Datasource;

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    /**
     * 配置动态数据源
     * @return
     */
    @Bean
    public DynamicDatasource getDatasources(){

        Map<Object,Object> map = new HashMap<>();
        map.put(studb1Datasource.getKeyword(),studb1Datasource.getDatasource());
        map.put(studb2Datasource.getKeyword(),studb2Datasource.getDatasource());

        //声明动态数据源
        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        //配置默认的数据源
        dynamicDatasource.setDefaultTargetDataSource(studb1Datasource.getDatasource());
        dynamicDatasource.setTargetDataSources(map);
        return dynamicDatasource;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DynamicDatasource getDatasources){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDatasources);
        try {
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }
}























