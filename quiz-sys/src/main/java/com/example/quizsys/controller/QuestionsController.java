package com.example.quizsys.controller;

import com.example.quizsys.domain.Categories;
import com.example.quizsys.dto.QuestionsDto;
import com.example.quizsys.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionService questionService;

    @GetMapping("/count/{count}/type/{type}/level/{level}")
    public List<QuestionsDto> getAll(@PathVariable("count") long count,
                                     @PathVariable("type") int type,
                                     @PathVariable("level") int level) {
        return questionService.getQuestionsWithAnswers(count, type, level);
    }

    @PostMapping("/categories")
    public List<QuestionsDto> getByCategories(@RequestBody Categories categories) {
        return questionService.getByCategories(categories);
    }

    @PostMapping
    public void add(@RequestBody QuestionsDto questionsDto) {
        questionService.add(questionsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        questionService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody QuestionsDto questionsDto) {
        questionService.updateById(questionsDto);
    }

}
