package com.example.quizsys.controller;

import com.example.quizsys.domain.RealExam;
import com.example.quizsys.dto.ExamDto;
import com.example.quizsys.dto.ExamersDto;
import com.example.quizsys.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/{count}")
    public List<ExamersDto> getAll(@PathVariable("count") long count){
        return examService.getAllExamDates(count);
    }

    @PostMapping("/manual")
    public void setManualExamForStudent(@RequestBody RealExam realExam) {
        examService.setManualExamForStudent(realExam);
    }

    @GetMapping("/random/student/{id}")
    public void setExamDateRandom(@PathVariable("id") long id) {
        examService.setRandomExamForStudent(id);
    }

}
















