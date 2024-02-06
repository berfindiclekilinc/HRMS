package com.example.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends Users {

    @Column (name="company_name")
    private String companyName ;

    @Column (name="website")
    private String website ;

    @Column (name="phone")
    private String phone;

}
