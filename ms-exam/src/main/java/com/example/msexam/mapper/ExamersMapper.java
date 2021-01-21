package com.example.msexam.mapper;

import com.example.msexam.domain.Examers;
import com.example.msexam.dto.ExamersDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExamersMapper {

    ExamersMapper INSTANCE = Mappers.getMapper(ExamersMapper.class);

    ExamersDto toDto(Examers examers);

    List<ExamersDto> toDtoList(List<Examers> examers);

}
