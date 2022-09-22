package com.ekiptesin.exam.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CandidateDto implements Serializable {
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String status;
}
