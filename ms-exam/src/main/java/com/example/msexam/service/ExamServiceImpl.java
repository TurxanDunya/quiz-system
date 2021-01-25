package com.example.msexam.service;

import com.example.msexam.client.FeignClientQuestion;
import com.example.msexam.client.FeignClientStudent;
import com.example.msexam.client.clientQuestion.model.Categories;
import com.example.msexam.client.clientQuestion.model.QuestionClientResponse;
import com.example.msexam.client.clientStudent.model.StudentClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final FeignClientQuestion clientQuestion;
    private final FeignClientStudent clientGroup;

    @Override
    public void assignQuestionsForGroup(long number, Categories categories) {

        StudentClientResponse clientResponse = clientGroup.getById(number);
        if (clientResponse != null) {
            QuestionClientResponse responseQuestions = clientQuestion.getQuestionsByCategories(categories);

            for (int questionNumber = 1; questionNumber < responseQuestions.getSize(); questionNumber++) {

            }
        }

    }

}
