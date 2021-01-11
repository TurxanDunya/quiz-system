package com.example.personsys.service;

import com.example.personsys.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto getById(long id);

    List<StudentDto> getAll();

    void add(StudentDto studentDto);

    void delete(long id);

    void updateById(StudentDto studentDto);

}
