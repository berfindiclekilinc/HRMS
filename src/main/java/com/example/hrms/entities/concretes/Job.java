package com.example.hrms.entities.concretes;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="job")
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

    public Job() {
    }

    public Job(int id, int empId, String description, String title) {
        this.id = id;
        this.empId = empId;
        this.description = description;
        this.title = title;
    }
}
