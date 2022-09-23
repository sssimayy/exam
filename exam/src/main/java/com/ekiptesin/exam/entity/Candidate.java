package com.ekiptesin.exam.entity;

import com.ekiptesin.exam.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 50, message = "Name length should be between 3 and 50.")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Surname cannot be empty.")
    @Column(name = "surname", nullable = false)
    @Size(min = 3, max = 50, message = "Surname length should be between 3 and 50.")
    private String surname;

    @Column(name = "email", unique = true)
    @Email(message = "Wrong email format!")
    @NotEmpty
    @NotBlank(message = "Email can not be empty!")
    private String email;

    @Column(name = "status") //Status
    private StatusEnum status;
}
