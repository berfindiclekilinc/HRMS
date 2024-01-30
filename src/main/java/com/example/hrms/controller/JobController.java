package com.example.hrms.controller;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/job")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public List<Job> getAll(){
        return this.jobService.getAll();
    }

    @PostMapping("list")
    public Result listJob(){
        return new Result(true, "All Jobs are listed.");
    }
}
