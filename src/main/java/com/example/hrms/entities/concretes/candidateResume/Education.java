package com.example.hrms.entities.concretes.candidateResume;

import com.example.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="candidate_education")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "start_year")
    private String startYear;

    @Column(name = "end_year")
    private String endYear;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
