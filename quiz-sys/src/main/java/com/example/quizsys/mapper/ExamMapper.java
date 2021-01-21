package com.example.quizsys.mapper;

import com.example.quizsys.domain.Exam;
import com.example.quizsys.dto.ExamDto;
import com.example.quizsys.dto.ExamersDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    ExamDto toDto(Exam exam);

    List<ExamersDto> toExamersDtos(List<ExamersDto> exams);

    Exam toDomain(ExamDto examDto);
}
