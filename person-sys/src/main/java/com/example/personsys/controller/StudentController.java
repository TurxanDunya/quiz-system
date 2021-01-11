package com.example.personsys.controller;

import com.example.personsys.dto.StudentDto;
import com.example.personsys.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable("id") long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid StudentDto studentDto) {
        studentService.add(studentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody @Valid StudentDto studentDto) {
        studentService.updateById(studentDto);
    }

}
