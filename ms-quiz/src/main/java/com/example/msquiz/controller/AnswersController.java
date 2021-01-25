package com.example.msquiz.controller;

import com.example.msquiz.domain.Questions;
import com.example.msquiz.domain.TrueAnswers;
import com.example.msquiz.service.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping("/true-answer")
    public List<TrueAnswers> getTrueAnswersByQuestionsIDs(@RequestBody List<Questions> questions) {
        return answersService.getTrueAnswersByQuestionsIDs(questions);
    }
}
