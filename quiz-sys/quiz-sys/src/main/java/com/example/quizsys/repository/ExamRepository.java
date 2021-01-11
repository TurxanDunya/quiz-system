package com.example.quizsys.repository;

import com.example.quizsys.domain.Exam;

import java.util.List;

public interface ExamRepository {

    List<Exam> getAllExamDates(long count);

    void assignExam(Exam exam);

}
