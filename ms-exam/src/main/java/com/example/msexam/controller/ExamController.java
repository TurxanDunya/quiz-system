package com.example.msexam.controller;

import com.example.msexam.domain.Exam;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;
import com.example.msexam.service.ExamService;
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
    public ExamDto setRandomExam() {
        return examService.assignRandomExam();
    }

    @GetMapping("/random/student/{id}")
    public ExamDto setManualExam(@RequestBody Exam exam) {
        return examService.assignRandomExam();
    }

}
















