package com.gulincover.other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableAsync
@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OtherMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OtherMainApplication.class, args);
    }
}
