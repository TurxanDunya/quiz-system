package com.example.msexam.controller;

import com.example.msexam.client.clientQuestion.model.Categories;
import com.example.msexam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/group/{number}/questions")
    public void assignQuestionsForStudent(@PathVariable("number") long number,
                                          @RequestBody Categories categories) {
        examService.assignQuestionsForGroup(number, categories);
    }
}
