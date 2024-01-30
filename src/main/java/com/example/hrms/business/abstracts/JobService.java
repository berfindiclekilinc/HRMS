package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();

}
