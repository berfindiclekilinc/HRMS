//package com.example.hrms.controller.cvControllers;
//
//import com.example.hrms.business.abstracts.cvAbstracts.*;
//import com.example.hrms.core.utilities.results.Result;
//import com.example.hrms.core.utilities.results.SuccessResult;
//import com.example.hrms.entities.concretes.candidateResume.*;
//import com.example.hrms.entities.dtos.CandidateResumeDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/cv")
//public class CvController {
//
//    private CoverLetterService coverLetterService;
//    private EducationService educationService;
//    private ExperienceService experienceService;
//    private LanguageService languageService;
//    private SkillService skillService;
//    private WebAddressService webAddressService;
//
//    @Autowired
//    public CvController(CoverLetterService coverLetterService, EducationService educationService, ExperienceService experienceService, LanguageService languageService, SkillService skillService, WebAddressService webAddressService) {
//        this.coverLetterService = coverLetterService;
//        this.educationService = educationService;
//        this.experienceService = experienceService;
//        this.languageService = languageService;
//        this.skillService = skillService;
//        this.webAddressService = webAddressService;
//    }
//
//    @PostMapping("/add")
//    public Result addCV(String email, String password,
//                        @RequestBody CoverLetter coverLetter,
//                        @RequestBody Education education,
//                        @RequestBody Experience experience,
//                        @RequestBody Language language,
//                        @RequestBody Skill skill,
//                        @RequestBody WebAddress webAddress
//                        ) {
//
//
//        this.coverLetterService.addByMail(email, password, coverLetter);
//
//        this.educationService.add(education);
//        this.languageService.add(language);
//        this.skillService.add(skill);
//        this.webAddressService.add(webAddress);
//        this.experienceService.add(experience);
//
//        return new SuccessResult("Cv added.");
//    }
//
//}
