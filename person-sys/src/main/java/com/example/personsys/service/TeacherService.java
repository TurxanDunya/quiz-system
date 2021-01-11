package com.example.personsys.service;

import com.example.personsys.dto.StudentDto;
import com.example.personsys.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto getById(long id);

    List<TeacherDto> getAll();

    void add(TeacherDto teacherDto);

    void delete(long id);

    void updateById(TeacherDto teacherDto);

    StudentDto assignStudent(long id);

}
