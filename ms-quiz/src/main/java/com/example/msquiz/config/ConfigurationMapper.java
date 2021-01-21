package com.example.msquiz.config;

import com.example.msquiz.mapper.QuestionsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public QuestionsMapper questionsMapper() {
        return QuestionsMapper.INSTANCE;
    }

}
