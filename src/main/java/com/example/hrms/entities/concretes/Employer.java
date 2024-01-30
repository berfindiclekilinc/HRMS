package com.example.hrms.entities.concretes;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column (name="userid")
    private int userId;

    @Column (name="company_name")
    private String companyName ;

    @Column (name="website")
    private String website ;

    @Column (name="phone")
    private String phone;

    public Employer() {
    }

    public Employer(int id, int userId, String companyName, String website, String phone) {
        this.id = id;
        this.userId = userId;
        this.companyName = companyName;
        this.website = website;
        this.phone = phone;
    }

}
