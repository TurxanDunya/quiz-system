package com.example.usersys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealExam {

    private long id;

    private LocalDateTime examDate;

    private LocalDateTime examExpirationDate;

    private String location;
}
