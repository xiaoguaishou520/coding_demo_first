package com.tencent.coding_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CodingGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingGatewayApplication.class, args);
    }

}
