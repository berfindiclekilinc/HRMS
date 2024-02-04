package com.example.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "staff")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffid")
    private int id;

    @Column (name="first_name")
    private String firstName ;

    @Column (name="last_name")
    private String lastName ;

}
