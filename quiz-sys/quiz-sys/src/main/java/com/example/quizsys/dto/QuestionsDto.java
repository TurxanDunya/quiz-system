package com.example.quizsys.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDto {

    private Long id;

    @NotNull
    private String question;

    private String subject;

    @NotNull
    @Size(min = 1, max = 4)
    private int type;
}
