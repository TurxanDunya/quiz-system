package com.example.quizsys.service;

import com.example.quizsys.domain.Questions;
import com.example.quizsys.dto.QuestionsDto;
import com.example.quizsys.mapper.QuestionsMapper;
import com.example.quizsys.repository.QuestionRepository;
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
