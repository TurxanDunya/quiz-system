package com.example.msexam.repository;

import com.example.msexam.client.clientExam.model.ExamClientResponse;
import com.example.msexam.client.clientStudent.model.StudentClientResponse;
import com.example.msexam.domain.Exam;
import com.example.msexam.domain.Examers;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;

import java.util.List;

public interface ExamTimingRepository {

    List<ExamersDto> getAllExamDates(long count);

    void assignExam(Exam exam);

    void setExamForStudent(ExamClientResponse examClientResponse,
                           StudentClientResponse studentClientResponse);

}
