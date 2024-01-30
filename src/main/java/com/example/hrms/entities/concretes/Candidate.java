package com.example.hrms.entities.concretes;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name="userid")
    private int userId;

    @Column (name="first_name")
    private String firstName ;

    @Column (name="last_name")
    private String lastName ;

    @Column (name="tc")
    private String tc;

    public Candidate(int id, int userId, String firstName, String lastName, String tc) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tc = tc;
    }

    public Candidate() {
    }


}
