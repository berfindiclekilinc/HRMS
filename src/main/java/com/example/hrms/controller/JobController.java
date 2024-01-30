package com.example.hrms.controller;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<Job>> getAll(){
        return this.jobService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Job job){
        return this.jobService.add(job);
    }

}
