package com.example.quizsys.config;

import com.example.quizsys.mapper.ExamMapper;
import com.example.quizsys.mapper.QuestionsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public QuestionsMapper questionsMapper() {
        return QuestionsMapper.INSTANCE;
    }

    @Bean
    public ExamMapper examMapper() {
        return ExamMapper.INSTANCE;
    }


}
