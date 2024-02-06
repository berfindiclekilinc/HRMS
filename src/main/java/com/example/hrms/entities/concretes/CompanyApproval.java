package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "company_approval")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CompanyApproval {

    @Id
    @GeneratedValue
    @Column(name = "comp_id")
    private int id;

    @Column (name="code")
    private String code ;

    @Column (name="is_verified")
    private boolean is_verified ;

}
