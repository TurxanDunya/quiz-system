package com.example.msquiz.service;

import com.example.msquiz.domain.Questions;
import com.example.msquiz.domain.TrueAnswers;

import java.util.List;

public interface AnswersService {

    List<TrueAnswers> getTrueAnswersByQuestionsIDs(List<Questions> questions);

}
