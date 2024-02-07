package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends Users  {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tc")
    private String tc;

    @Column(name = "birth_year")
    private Integer birthYear;

    @JsonIgnore
    @Column(name="is_verified")
    private boolean is_verified;

}
