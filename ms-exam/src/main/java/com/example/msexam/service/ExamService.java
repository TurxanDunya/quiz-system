package com.example.msexam.service;

import com.example.msexam.domain.Exam;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;

import java.util.List;

public interface ExamService {

    List<ExamersDto> getAllExamDates(long count);

    ExamDto assignRandomExam();

    ExamDto assignManualExam(Exam exam);

}
