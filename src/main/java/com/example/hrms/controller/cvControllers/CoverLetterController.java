package com.example.hrms.controller.cvControllers;

import com.example.hrms.business.abstracts.cvAbstracts.*;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.candidateResume.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coverletter")
public class CoverLetterController {

    private CoverLetterService coverLetterService;


    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;

    }

    @PostMapping("/add")
    public Result addCV(String email, String password,
                        @RequestBody CoverLetter coverLetter)
    {

        this.coverLetterService.addByMail(email, password, coverLetter);

        return new SuccessResult("Cv added.");
    }

}
