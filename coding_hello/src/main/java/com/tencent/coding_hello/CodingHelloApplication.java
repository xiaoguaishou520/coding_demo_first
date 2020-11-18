package com.tencent.coding_hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.tencent",exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@MapperScan("com.tencent.dao")
public class CodingHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingHelloApplication.class, args);
    }

}
