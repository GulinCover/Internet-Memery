package com.gulincover.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class TopicMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopicMainApplication.class, args);
    }
}
