package com.example.msexam.service;

import com.example.msexam.domain.RealExam;
import com.example.msexam.dto.ExamersDto;

import java.util.List;

public interface ExamService {

    List<ExamersDto> getAllExamDates(long count);

    void setManualExamForStudent(RealExam exam);

    void setRandomExamForStudent(long id);

}
