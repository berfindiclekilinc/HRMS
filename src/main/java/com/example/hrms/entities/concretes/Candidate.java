package com.example.hrms.entities.concretes;

import com.example.hrms.entities.concretes.candidateResume.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


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


    @OneToOne(mappedBy = "candidate")
    private CoverLetter candidateCoverLetter;

    @OneToOne(mappedBy = "candidate")
    private WebAddress candidateWebAddress;


    @OneToMany(mappedBy = "candidate")
    private List<Experience> candidateExperience;

    @OneToMany(mappedBy = "candidate")
    private List<Language> candidateLanguage;

    @OneToMany(mappedBy = "candidate")
    private List<Education> candidateEducation;

    @OneToMany(mappedBy = "candidate")
    private List<Skill> candidateSkill;

}
