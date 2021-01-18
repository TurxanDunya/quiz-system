package com.example.quizsys.controller;

import com.example.quizsys.domain.ExamFilter;
import com.example.quizsys.dto.ExamDto;
import com.example.quizsys.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new-exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping
    public ExamDto newExam() {
        return examService.assignRandomExam();
    }

    @GetMapping("/{count}")
    public List<ExamDto> getAll(@PathVariable("count") long count){
        return examService.getAllExamDates(count);
    }

    @PostMapping
    public ExamDto assignExam(@RequestBody ExamFilter examFilter) {
        return examService.assignManualExam(examFilter);
    }
}
















