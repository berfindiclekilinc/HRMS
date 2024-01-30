package com.example.hrms.entities.concretes;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Users(int id, String email, String password) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }
}
