package com.example.usersys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam-questions")
@RequiredArgsConstructor
public class ExamQuestionsController {

    @GetMapping()
    public void setQuestionStudentForExamType() {

    }

}
