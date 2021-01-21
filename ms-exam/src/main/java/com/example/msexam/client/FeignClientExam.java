package com.example.msexam.client;

import com.example.msexam.client.model.ExamClientRequest;
import com.example.msexam.client.model.ExamClientResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/new-exam")
@FeignClient(name = "quiz-sys-exam", url = "http://localhost:8080",
        configuration = FeignClientExam.FeignConfigurationExam.class, primary = false)
public interface FeignClientExam {

    @GetMapping
    ExamClientResponse assignRandomExam();

    @GetMapping("/{count}")
    List<ExamClientResponse> getAllExamDates(@PathVariable("count") long count);

    @PostMapping
    ExamClientResponse assignManualExam(@RequestBody ExamClientRequest examClient);

    class FeignConfigurationExam {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }
}
