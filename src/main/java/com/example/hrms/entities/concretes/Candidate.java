package com.example.hrms.entities.concretes;

import com.example.hrms.entities.concretes.candidateResume.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisments"})
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


    /////
    @JsonIgnore
    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CoverLetter candidateCoverLetter;

    @JsonIgnore
    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private WebAddress candidateWebAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Experience> candidateExperience;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Language> candidateLanguage;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Education> candidateEducation;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Skill> candidateSkill;

}
