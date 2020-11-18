package com.tencent.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;

import javax.sql.DataSource;

@Data
public class BaseDatasource {

    protected String url;
    protected String username;
    protected String password;
    protected String driverClassName;
    protected String keyword;


    /**
     * 手动配置数据源
     * @return
     */
    public DataSource getDatasource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return hikariDataSource;
    }

}
























