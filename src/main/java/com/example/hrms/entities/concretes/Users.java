package com.example.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int id;

    @NotNull(message="Email can't be null.")
    @NotBlank(message="Email can't be empty.")
    @Column(name = "email")
    private String email;

    @NotNull(message="Password can't be null.")
    @NotBlank(message="Password can't be empty.")
    @Column(name = "password")
    private String password;

    /*@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Candidate candidate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employer employer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Staff staff;*/


}
