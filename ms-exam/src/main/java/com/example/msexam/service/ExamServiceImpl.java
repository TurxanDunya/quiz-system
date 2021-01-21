package com.example.msexam.service;

import com.example.msexam.domain.Exam;
import com.example.msexam.dto.ExamDto;
import com.example.msexam.dto.ExamersDto;
import com.example.msexam.mapper.ExamMapper;
import com.example.msexam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{

    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    @Override
    public List<ExamersDto> getAllExamDates(long count) {
        return examMapper.toExamersDtos(examRepository.getAllExamDates(count));
    }

    @Override
    public ExamDto assignRandomExam() {

        Random r = new Random();
        LocalDateTime dateTime = LocalDateTime.now();
        ExamDto examDto = new ExamDto();

        examDto.setExamDate(dateTime);
        examDto.setLocation(r.nextInt(300) + " sayli merkez");
        examDto.setExamExpirationDate(dateTime.plusMinutes(90L));

        examRepository.assignExam(examMapper.toDomain(examDto));
        return examDto;
    }

    @Override
    public ExamDto assignManualExam(Exam exam) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(exam.getExamDate().toString(), formatter);

        ExamDto examDto = new ExamDto();

        examDto.setExamDate(time);
        examDto.setLocation(exam.getLocation());

        LocalDateTime localDateTime = examDto.getExamDate();
        examDto.setExamExpirationDate(localDateTime.plusMinutes(90L));

        examRepository.assignExam(examMapper.toDomain(examDto));
        return examDto;
    }

}
