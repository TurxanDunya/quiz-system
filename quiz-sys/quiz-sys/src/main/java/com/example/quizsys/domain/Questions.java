package com.example.quizsys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Questions {

    private Long id;

    private String question;

    private String subject;

    private int type;

}
