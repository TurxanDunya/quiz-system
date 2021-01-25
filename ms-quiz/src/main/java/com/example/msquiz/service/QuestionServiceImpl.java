package com.example.msquiz.service;

import com.example.msquiz.domain.Categories;
import com.example.msquiz.domain.Questions;
import com.example.msquiz.dto.QuestionsDto;
import com.example.msquiz.mapper.QuestionsMapper;
import com.example.msquiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionsMapper questionsMapper;

    @Override
    public List<QuestionsDto> getQuestionsWithAnswers(long count, int type, int level) {

        List<Questions> byType = questionRepository.findByType(type);

        List<Questions> questionsByLevel = byType.stream()
                .filter(questions -> questions.getLevel() == level)
                .limit(count)
                .collect(Collectors.toList());

        List<QuestionsDto> questionsDto = questionsMapper.toQuestionDtos(questionsByLevel);
        for (QuestionsDto addToDto : questionsDto) {
            addToDto.setAnswers(questionRepository.getAnswerByQuestionId(addToDto.getId()));
        }

        return questionsDto;
    }

    @Override
    public List<QuestionsDto> getByCategories(Categories categories) {

        List<Questions> byType = questionRepository.findByType(categories.getType());

        List<Questions> questionsByLevel = byType.stream()
                .filter(questions -> questions.getLevel() == categories.getLow() ||
                        questions.getLevel() == categories.getNormal() ||
                        questions.getLevel() == categories.getHard())
                .limit(categories.getLow() + categories.getNormal() + categories.getHard())
                .collect(Collectors.toList());

        List<QuestionsDto> questionsDto = questionsMapper.toQuestionDtos(questionsByLevel);
        for (QuestionsDto addToDto : questionsDto) {
            addToDto.setAnswers(questionRepository.getAnswerByQuestionId(addToDto.getId()));
        }

        return questionsDto;
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
