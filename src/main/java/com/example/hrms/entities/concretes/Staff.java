package com.example.hrms.entities.concretes;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "staff")
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffid")
    private int id;

    @Column (name="userid")
    private int userId;

    @Column (name="first_name")
    private String firstName ;

    @Column (name="last_name")
    private String lastName ;

    public Staff() {
    }

    public Staff(int id, int userId, String firstName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
