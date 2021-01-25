package com.example.msexam.controller;

import com.example.msexam.domain.RealExam;
import com.example.msexam.dto.ExamersDto;
import com.example.msexam.service.ExamTimingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamTimingController {

    private final ExamTimingService examService;

    @GetMapping("/{count}")
    public List<ExamersDto> getAll(@PathVariable("count") long count){
        return examService.getAllExamDates(count);
    }

    @GetMapping("/manual/student/{id}")
    public void setRandomExam(@RequestBody RealExam exam) {
        examService.setManualExamForStudent(exam);
    }

    @GetMapping("/random/student/{id}")
    public void setManualExam(@PathVariable("id") long id) {
        examService.setRandomExamForStudent(id);
    }

}
















