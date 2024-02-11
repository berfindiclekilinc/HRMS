package com.example.hrms.entities.concretes.candidateResume;

import com.example.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="candidate_cover_letter")
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetter {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
