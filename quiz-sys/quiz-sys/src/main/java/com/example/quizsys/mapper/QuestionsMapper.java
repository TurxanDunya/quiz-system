package com.example.quizsys.mapper;

import com.example.quizsys.domain.Questions;
import com.example.quizsys.dto.QuestionsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionsMapper {

    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

    QuestionsDto toDto(Questions questions);

    List<QuestionsDto> toQuestionDtos(List<Questions> questions);

    Questions toDomain(QuestionsDto questionsDto);
}
