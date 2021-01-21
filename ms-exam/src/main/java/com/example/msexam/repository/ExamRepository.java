package com.example.msexam.repository;

import com.example.msexam.domain.Exam;
import com.example.msexam.domain.Examers;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;

import java.util.List;

public interface ExamRepository {

    List<ExamersDto> getAllExamDates(long count);

    void assignExam(Exam exam);

    void setExamForStudent(ExamDto examDto,
                           Examers examers);

}
