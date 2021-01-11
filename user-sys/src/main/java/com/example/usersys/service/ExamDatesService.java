package com.example.usersys.service;

import com.example.usersys.domain.RealExam;
import com.example.usersys.dto.ExamersDto;

import java.util.List;

public interface ExamDatesService {

    void setManualExamForStudent(RealExam exam);

    void setRandomExamForStudent(long id);

    List<ExamersDto> getAllExamDates(long count);

}
