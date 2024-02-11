package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDto {

    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String schoolName;
    private String startYear;
    private String endYear;
    private String company;
    private String position;
    private String jobStartYear;
    private String jobEndYear;
    private String languageLevel;
    private String languageName;
    public String knownTechnology;
    public String linkedin;
    public String github;
    public String coverLetter;


}
