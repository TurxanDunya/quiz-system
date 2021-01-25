package com.example.msexam.service;

import com.example.msexam.client.clientQuestion.model.Categories;

public interface ExamService {

    void assignQuestionsForGroup(long number, Categories categories);

}
