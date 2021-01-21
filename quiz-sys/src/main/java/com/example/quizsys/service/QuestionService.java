package com.example.quizsys.service;

import com.example.quizsys.domain.Categories;
import com.example.quizsys.dto.QuestionsDto;

import java.util.List;

public interface QuestionService {

    List<QuestionsDto> getQuestionsWithAnswers(long count, int type, int level);

    List<QuestionsDto> getByCategories(Categories categories);

    void add(QuestionsDto questionsDto);

    void delete(long id);

    void updateById(QuestionsDto questionsDto);

}
