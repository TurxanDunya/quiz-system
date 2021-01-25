package com.example.msexam.client;

import com.example.msexam.client.clientQuestion.model.Categories;
import com.example.msexam.client.clientQuestion.model.QuestionClientRequest;
import com.example.msexam.client.clientQuestion.model.QuestionClientResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/questions")
@FeignClient(name = "quiz-sys-question", url = "http://localhost:8080",
        configuration = FeignClientQuestion.FeignConfigurationQuestion.class, primary = false)
public interface FeignClientQuestion {

    @GetMapping("count/{count}/type/{type}/level/{level}")
    List<QuestionClientResponse> getQuestionsByParameters(@PathVariable("count") long count,
                                        @PathVariable("type") int type,
                                        @PathVariable("level") int level);

    @PostMapping("/categories")
    QuestionClientResponse getQuestionsByCategories(@RequestBody Categories categories);

    @PostMapping
    void add(@RequestBody QuestionClientRequest questionClient);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id);

    @PutMapping("/{id}")
    void update(@RequestBody QuestionClientRequest questionClient);

    class FeignConfigurationQuestion {
        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }
}
