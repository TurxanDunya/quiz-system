package com.example.quizsys.service;

import com.example.quizsys.domain.ExamFilter;
import com.example.quizsys.dto.ExamDto;

import java.util.List;

public interface ExamService {

    List<ExamDto> getAllExamDates(long count);

    ExamDto assignRandomExam();

    ExamDto assignManualExam(ExamFilter examFilter);

}
