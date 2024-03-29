package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "candidate_approval")
@Entity

@AllArgsConstructor
@NoArgsConstructor
public class CandidateApproval {

    @Id
    @Column(name = "candidate_id")
    private int id;

    @Column (name="code")
    private String code ;

    @Column (name="is_verified")
    private boolean is_verified ;

}
