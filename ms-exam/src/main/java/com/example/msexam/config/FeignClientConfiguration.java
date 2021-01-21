package com.example.msexam.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.example.msexam.client"})
public class FeignClientConfiguration {
}
