package com.bison.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BisonSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BisonSystemApplication.class, args);
    }

}
