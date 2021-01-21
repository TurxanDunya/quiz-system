package com.example.quizsys.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.example.quizsys.client"})
public class FeignClientConfiguration {
}
