package com.example.personsys.mapper;

import com.example.personsys.domain.Teacher;
import com.example.personsys.dto.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto toDto(Teacher teacher);

    List<TeacherDto> toTeacherDtos(List<Teacher> teachers);

    Teacher toDomain(TeacherDto teacherDto);
}
