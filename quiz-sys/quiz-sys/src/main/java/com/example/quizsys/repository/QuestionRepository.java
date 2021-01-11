package com.example.quizsys.repository;

import com.example.quizsys.domain.Questions;

import java.util.List;

public interface QuestionRepository {

    List<Questions> findByType(int type);

    List<Questions> findAll(long count);

    void add(Questions questions);

    void delete(long questionId);

    void updateById(Questions questions);

}
