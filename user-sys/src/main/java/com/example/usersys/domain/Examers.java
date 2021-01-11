package com.example.usersys.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Examers {

    private Long id;

    private String name;

    private String surname;

    private String exam;

}
