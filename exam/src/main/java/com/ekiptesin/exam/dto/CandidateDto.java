package com.ekiptesin.exam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateDto {
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String status;
}
