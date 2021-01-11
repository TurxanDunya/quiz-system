package com.example.quizsys.service;

import com.example.quizsys.dto.QuestionsDto;

import java.util.List;

public interface QuestionService {

    List<QuestionsDto> getByType(int type);

    List<QuestionsDto> getAll(long count);

    void add(QuestionsDto questionsDto);

    void delete(long id);

    void updateById(QuestionsDto questionsDto);

}
