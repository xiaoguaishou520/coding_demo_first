package com.tencent.coding_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CodingConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingConfigApplication.class, args);
    }

}
