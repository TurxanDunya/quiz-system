package com.example.quizsys.client;

import com.example.quizsys.client.clientStudent.model.StudentClientRequest;
import com.example.quizsys.client.clientStudent.model.StudentClientResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@FeignClient(name = "quiz-sys-students", url = "http://localhost:8081",
        configuration = FeignClientStudent.FeignConfigurationStudent.class, primary = false)
public interface FeignClientStudent {

    @GetMapping
    List<StudentClientResponse> getAll();

    @GetMapping("/{id}")
    StudentClientResponse getById(@PathVariable("id") Long id);

    @PostMapping
    void add(@RequestBody StudentClientRequest studentClient);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id);

    @PutMapping("/{id}")
    void update(@RequestBody StudentClientRequest studentClient);

    class FeignConfigurationStudent {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }


}
