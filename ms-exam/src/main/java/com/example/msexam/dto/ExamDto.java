package com.example.msexam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {

    @NotNull
    private LocalDateTime examDate;

    private LocalDateTime examExpirationDate;

    @NotNull
    private String location;
}
