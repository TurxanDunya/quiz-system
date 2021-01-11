package com.example.personsys.service;

import com.example.personsys.dto.StudentDto;
import com.example.personsys.dto.TeacherDto;
import com.example.personsys.mapper.StudentMapper;
import com.example.personsys.mapper.TeacherMapper;
import com.example.personsys.repository.StudentRepository;
import com.example.personsys.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public TeacherDto getById(long id) {
        return teacherMapper.toDto(teacherRepository.getById(id));
    }

    @Override
    public List<TeacherDto> getAll() {
        return teacherMapper.toTeacherDtos(teacherRepository.findAll());
    }

    @Override
    public void add(TeacherDto teacherDto) {
        teacherRepository.add(teacherMapper.toDomain(teacherDto));
    }

    @Override
    public void delete(long id) {
        teacherRepository.delete(id);
    }

    @Override
    public void updateById(TeacherDto teacherDto) {
        teacherRepository.updateById(teacherDto);
    }

    @Override
    public StudentDto assignStudent(long id) {
        return studentMapper.toDto(studentRepository.getById(id));
    }

}
