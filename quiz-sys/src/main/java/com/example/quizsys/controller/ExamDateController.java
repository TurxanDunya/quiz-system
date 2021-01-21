package com.example.quizsys.controller;

import com.example.quizsys.domain.RealExam;
import com.example.quizsys.dto.ExamersDto;
import com.example.quizsys.service.ExamDatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamDateController {

    private final ExamDatesService examDatesService;

    @GetMapping
    public List<ExamersDto> getAllExamDates(long count) {
        return examDatesService.getAllExamDates(count);
    }

    @PostMapping("/manual")
    public void setExamDateManual(@RequestBody RealExam realExam) {
        examDatesService.setManualExamForStudent(realExam);
    }

    @GetMapping("/random/student/{id}")
    public void setExamDateRandom(@PathVariable("id") long id) {
        examDatesService.setRandomExamForStudent(id);
    }

}
