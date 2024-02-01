package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="job")

@AllArgsConstructor
@NoArgsConstructor
public class Job{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;

    @Column (name="emp_id")
    private int empId;

    @Column (name="description")
    private String description ;

    @Column (name="title")
    private String title ;
}
