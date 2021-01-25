package com.example.msquiz.service;

import com.example.msquiz.domain.Questions;
import com.example.msquiz.domain.TrueAnswers;
import com.example.msquiz.repository.AnswersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswersServiceImpl implements AnswersService {

    private final AnswersRepository answersRepository;

    @Override
    public List<TrueAnswers> getTrueAnswersByQuestionsIDs(List<Questions> questions) {
        return answersRepository.getTrueAnswersByQuestionsIDs(questions);
    }
}
