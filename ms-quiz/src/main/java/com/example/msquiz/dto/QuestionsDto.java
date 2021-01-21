package com.example.msquiz.dto;

import com.example.msquiz.domain.Answers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

    @Size(min = 1, max = 3)
    private int level;

    private List<Answers> answers;

}
