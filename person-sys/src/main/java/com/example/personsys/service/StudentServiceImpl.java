package com.example.personsys.service;

import com.example.personsys.dto.StudentDto;
import com.example.personsys.mapper.StudentMapper;
import com.example.personsys.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public StudentDto getById(long id) {
        return studentMapper.toDto(studentRepository.getById(id));
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toStudentDtos(studentRepository.getAll());
    }

    @Override
    public void add(StudentDto studentDto) {
        studentRepository.add(studentMapper.toDomain(studentDto));
    }

    @Override
    public void delete(long id) {
        studentRepository.delete(id);
    }

    @Override
    public void updateById(StudentDto studentDto) {
        studentRepository.updateById(studentDto);
    }
}
