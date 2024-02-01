package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users user;*/

    @NotNull(message = "First name can't be null.")
    @NotBlank(message = "First name can't be empty.")
    @NotEmpty(message = "TC can't be empty.")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name can't be null.")
    @NotBlank(message = "Last name can't be empty.")
    @NotEmpty(message = "TC can't be empty.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "TC can't be null.")
    @NotBlank(message = "TC can't be empty.")
    @NotEmpty(message = "TC can't be empty.")
    @Column(name = "tc")
    private String tc;

    @NotNull(message = "Birth year can't be null.")
    @Column(name = "birth_year")
    private Integer birthYear;

}
