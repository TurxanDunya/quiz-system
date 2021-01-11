package com.example.quizsys.service;

import com.example.quizsys.domain.Questions;
import com.example.quizsys.dto.QuestionsDto;
import com.example.quizsys.mapper.QuestionsMapper;
import com.example.quizsys.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final QuestionsMapper questionsMapper;

    @Override
    public List<QuestionsDto> getByType(int type) {
        return questionsMapper.toQuestionDtos(questionRepository.findByType(type));
    }

    @Override
    public List<QuestionsDto> getAll(long count) {
        return questionsMapper.toQuestionDtos(questionRepository.findAll(count));
    }

    @Override
    public void add(QuestionsDto questionsDto) {
        questionRepository.add(questionsMapper.toDomain(questionsDto));
    }

    @Override
    public void delete(long id) {
        questionRepository.delete(id);
    }

    @Override
    public void updateById(QuestionsDto questionsDto) {
        questionRepository.updateById(questionsMapper.toDomain(questionsDto));
    }
}
