package com.example.msexam.service;

import com.example.msexam.domain.Exam;
import com.example.msexam.domain.RealExam;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;

import java.util.List;

public interface ExamTimingService {

    List<ExamersDto> getAllExamDates(long count);

    ExamDto assignRandomExam();

    ExamDto assignManualExam(Exam exam);

    void setManualExamForStudent(RealExam exam);

    void setRandomExamForStudent(long id);

}
