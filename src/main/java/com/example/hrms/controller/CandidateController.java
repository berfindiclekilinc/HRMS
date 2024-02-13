package com.example.hrms.controller;


import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.CandidateVerificationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.dtos.CandidateResumeDto;
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

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("/getCV")
    public DataResult<List<CandidateResumeDto>> getCandidateFullCv() {
        return this.candidateService.getCandidateCv();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PostMapping("/add/verifyEmail")
    public Result verifyEmail(String email, String verificationCode) {
        return this.candidateVerificationService.verifyEmail(email, verificationCode);
    }

}
