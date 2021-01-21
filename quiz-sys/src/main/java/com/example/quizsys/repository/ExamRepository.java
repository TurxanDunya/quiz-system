package com.example.quizsys.repository;

import com.example.quizsys.client.clientStudent.model.StudentClientResponse;
import com.example.quizsys.domain.Exam;
import com.example.quizsys.dto.ExamDto;
import com.example.quizsys.dto.ExamersDto;

import java.util.List;

public interface ExamRepository {

    List<ExamersDto> getAllExamDates(long count);

    void assignExam(Exam exam);

    void setExamForStudent(ExamDto examDto,
                           StudentClientResponse studentClientResponse);

}
