package com.example.msquiz.repository;

import com.example.msquiz.domain.Answers;
import com.example.msquiz.domain.Questions;

import java.util.List;

public interface QuestionRepository {

    List<Answers> getAnswerByQuestionId(long id);

    List<Questions> findByType(int type);

    void add(Questions questions);

    void delete(long questionId);

    void updateById(Questions questions);

}
