package com.tencent.coding_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CodingEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingEurekaApplication.class, args);
    }

}
