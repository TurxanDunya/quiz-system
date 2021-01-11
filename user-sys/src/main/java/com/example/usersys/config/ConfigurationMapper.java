package com.example.usersys.config;

import com.example.usersys.mapper.ExamersMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public ExamersMapper examMapper() {
        return ExamersMapper.INSTANCE;
    }

}
