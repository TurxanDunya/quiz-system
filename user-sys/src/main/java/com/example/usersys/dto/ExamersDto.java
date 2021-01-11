package com.example.usersys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamersDto {

    private Long id;

    private String name;

    private String surname;

    private String exam;

    private LocalDateTime examDate;

    private LocalDateTime examExpirationDate;

    private String location;

}
