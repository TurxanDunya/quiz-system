package com.example.msexam.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private LocalDateTime examDate;

    private LocalDateTime examExpirationDate;

    private String location;
}
