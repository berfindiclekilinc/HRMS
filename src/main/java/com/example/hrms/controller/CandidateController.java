package com.example.hrms.controller;


import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.CandidateVerificationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    private CandidateService candidateService;
    private CandidateVerificationService candidateVerificationService;

    @Autowired
    public CandidateController(CandidateService candidateService, CandidateVerificationService candidateVerificationService){
        super();
        this.candidateVerificationService = candidateVerificationService;
        this.candidateService=candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PostMapping("/add/verifyemail")
    public Result verifyEmail(String email, String verificationCode) {
        return this.candidateVerificationService.verifyEmail(email, verificationCode);
    }
}
