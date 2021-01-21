package com.example.quizsys.service;

import com.example.quizsys.domain.RealExam;
import com.example.quizsys.dto.ExamersDto;

import java.util.List;

public interface ExamDatesService {

    void setManualExamForStudent(RealExam exam);

    void setRandomExamForStudent(long id);

    List<ExamersDto> getAllExamDates(long count);

}
