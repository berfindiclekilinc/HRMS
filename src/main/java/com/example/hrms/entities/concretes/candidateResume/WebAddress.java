package com.example.hrms.entities.concretes.candidateResume;

import com.example.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "candidate_web_adress")
@AllArgsConstructor
@NoArgsConstructor
public class WebAddress {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
