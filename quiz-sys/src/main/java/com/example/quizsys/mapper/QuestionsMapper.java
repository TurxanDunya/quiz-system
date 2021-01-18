package com.example.quizsys.mapper;

import com.example.quizsys.domain.Questions;
import com.example.quizsys.dto.QuestionsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionsMapper {

    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

    @Mapping(target = "answers", ignore = true)
    QuestionsDto toDto(Questions questions);

    List<QuestionsDto> toQuestionDtos(List<Questions> questions);

    Questions toDomain(QuestionsDto questionsDto);
}
