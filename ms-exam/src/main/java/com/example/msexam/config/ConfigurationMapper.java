package com.example.msexam.config;

import com.example.msexam.mapper.ExamMapper;
import com.example.msexam.mapper.ExamersMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public ExamMapper examMapper() {
        return ExamMapper.INSTANCE;
    }

    @Bean
    public ExamersMapper examersMapper() {
        return ExamersMapper.INSTANCE;
    }

}
