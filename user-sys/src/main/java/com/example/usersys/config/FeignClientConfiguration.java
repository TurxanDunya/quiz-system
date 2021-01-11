package com.example.usersys.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.example.usersys.client"})
public class FeignClientConfiguration {
}
