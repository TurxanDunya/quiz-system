package com.example.usersys.client;

import com.example.usersys.client.clientTeacher.model.TeacherClientRequest;
import com.example.usersys.client.clientTeacher.model.TeacherClientResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teachers")
@FeignClient(name = "quiz-sys-teachers", url = "http://localhost:8081",
        configuration = FeignClientTeacher.FeignConfigurationTeacher.class, primary = false)
public interface FeignClientTeacher {

    @GetMapping
    List<TeacherClientResponse> getAll();

    @GetMapping("/{id}")
    TeacherClientResponse getById(@PathVariable("id") Long id);

    @PostMapping
    void add(@RequestBody TeacherClientRequest teacherClient);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id);

    @PutMapping("/{id}")
    void update(@RequestBody TeacherClientRequest teacherClient);

    class FeignConfigurationTeacher {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }
}
