package com.example.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "employer")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name="company_name")
    private String companyName ;

    @Column (name="website")
    private String website ;

    @Column (name="phone")
    private String phone;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users user;*/

}
