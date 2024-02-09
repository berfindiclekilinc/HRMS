package com.example.hrms.controller;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Job;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getActive")
    public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisements() {
        return this.jobAdvertisementService.getAllActiveJobAdvertisements();}

    @GetMapping("/getActive/sortedByDate")
    public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementsSortedByDate() {
        return this.jobAdvertisementService.findByStatusTrueOrderByApplicationStart();
    }

    @PostMapping("/closeAdvertisement")
    public Result closeAdversitement(int advertisementId){
        return this.jobAdvertisementService.setStatusFalse(advertisementId);
    }


}
