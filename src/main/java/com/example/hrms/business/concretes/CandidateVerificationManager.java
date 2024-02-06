package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateVerificationService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.CandidateApprovalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CandidateVerificationManager implements CandidateVerificationService {

    private CandidateApprovalDao candidateApprovalDao;

    @Autowired
    public CandidateVerificationManager(CandidateApprovalDao candidateApprovalDao) {
        this.candidateApprovalDao = candidateApprovalDao;
    }

    public static String GenerateVerificationCode(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder verificationCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            verificationCode.append(characters.charAt(randomIndex));
        }

        return verificationCode.toString();
    }

    @Override
    public Result verifyEmail(String verificationCode) {

        return null;
    }
}