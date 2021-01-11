package com.example.personsys.config;

import com.example.personsys.mapper.StudentMapper;
import com.example.personsys.mapper.TeacherMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationMapper {

    @Bean
    public TeacherMapper teacherMapper() {

        return TeacherMapper.INSTANCE;

    }

    @Bean
    public StudentMapper studentMapper() {

        return StudentMapper.INSTANCE;

    }

}
