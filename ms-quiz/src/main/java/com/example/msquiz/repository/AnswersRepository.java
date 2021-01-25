package com.example.msquiz.repository;

import com.example.msquiz.domain.Questions;
import com.example.msquiz.domain.TrueAnswers;

import java.util.List;

public interface AnswersRepository {

    List<TrueAnswers> getTrueAnswersByQuestionsIDs(List<Questions> questions);

}
