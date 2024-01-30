package com.example.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "candidate_approval")
@Entity
public class CandidateApproval {

    @Id
    @GeneratedValue
    @Column(name = "candidate_id")
    private int id;

    @Column (name="code")
    private String code ;

    @Column (name="is_verified")
    private boolean is_verified ;

    public CandidateApproval() {
    }

    public CandidateApproval(int id, String code, boolean is_verified) {
        this.id = id;
        this.code = code;
        this.is_verified = is_verified;
    }
}
