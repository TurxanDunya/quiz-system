package com.example.usersys.controller;

import com.example.usersys.domain.RealExam;
import com.example.usersys.dto.ExamersDto;
import com.example.usersys.service.ExamDatesService;
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
