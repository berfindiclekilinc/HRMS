package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_position_count")
    private int jobPositionCount;

    @Column(name = "application_start")
    private Date applicationStart;

    @Column(name = "Application_dead_line")
    private Date ApplicationDeadLine;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "status")
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Company company;
    @ManyToOne()
    @JoinColumn(name = "city")
    private City city;
    @ManyToOne()
    @JoinColumn(name = "job_title")
    private Job jobTitle;

}
