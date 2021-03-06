package com.example.msexam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private LocalDateTime examExpirationDate;

    private String location;
}
