package com.example.personsys.repository;

import com.example.personsys.domain.Student;
import com.example.personsys.dto.StudentDto;

import java.util.List;

public interface StudentRepository {

    Student getById(long studentId);

    List<Student> getAll();

    void add(Student student);

    void delete(long studentId);

    void updateById(StudentDto studentDto);

}
