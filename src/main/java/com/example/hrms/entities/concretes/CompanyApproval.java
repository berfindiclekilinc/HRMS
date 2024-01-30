package com.example.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "company_approval")
@Entity
public class CompanyApproval {

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private int id;

    @Column (name="code")
    private String code ;

    @Column (name="is_verified")
    private boolean is_verified ;

    public CompanyApproval() {
    }

    public CompanyApproval(int id, String code, boolean is_verified) {
        this.id = id;
        this.code = code;
        this.is_verified = is_verified;
    }
}
