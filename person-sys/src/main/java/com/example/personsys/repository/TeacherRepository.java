package com.example.personsys.repository;

import com.example.personsys.domain.Teacher;
import com.example.personsys.dto.TeacherDto;

import java.util.List;

public interface TeacherRepository {

    Teacher getById(long teacherId);

    List<Teacher> findAll();

    void add(Teacher teacher);

    void delete(long teacherId);

    void updateById(TeacherDto teacherDto);

}
