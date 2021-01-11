package com.example.personsys.mapper;

import com.example.personsys.domain.Student;
import com.example.personsys.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);

    List<StudentDto> toStudentDtos(List<Student> students);

    Student toDomain(StudentDto studentDto);
}
