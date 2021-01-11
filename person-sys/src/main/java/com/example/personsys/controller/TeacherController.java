package com.example.personsys.controller;

import com.example.personsys.dto.StudentDto;
import com.example.personsys.dto.TeacherDto;
import com.example.personsys.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherDto> findAll(){
        return teacherService.getAll();
    }

    @GetMapping(path = "/{id}")
    public TeacherDto findById(@PathVariable("id") long id){
        return teacherService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid TeacherDto teacherDto){
        teacherService.add(teacherDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        teacherService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateById(@RequestBody @Valid TeacherDto teacherDto){
        teacherService.updateById(teacherDto);
    }

    @GetMapping("/assign/{id}")
    public StudentDto assignStudent(@PathVariable("id") long id) {
        return teacherService.assignStudent(id);
    }
}
