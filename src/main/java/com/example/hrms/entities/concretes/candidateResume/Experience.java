package com.example.hrms.entities.concretes.candidateResume;


import com.example.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="candidate_experience")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "company")
    private String company;

    @Column(name = "posiiton")
    private String position;

    @Column(name = "start_year")
    private String jobStartYear;

    @Column(name = "end_year")
    private String jobEndYear;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


}
