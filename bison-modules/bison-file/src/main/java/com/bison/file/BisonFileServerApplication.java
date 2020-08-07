package com.bison.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BisonFileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BisonFileServerApplication.class, args);
    }

}
