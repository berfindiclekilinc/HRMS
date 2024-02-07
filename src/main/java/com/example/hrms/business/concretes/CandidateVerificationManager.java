package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateVerificationService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateApprovalDao;

import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateApproval;
import com.example.hrms.entities.concretes.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CandidateVerificationManager implements CandidateVerificationService {

    private CandidateApprovalDao candidateApprovalDao;
    private CandidateDao candidateDao;
    private UsersDao usersDao;


    @Autowired
    public CandidateVerificationManager(CandidateApprovalDao candidateApprovalDao, CandidateDao candidateDao, UsersDao usersDao) {
        this.candidateApprovalDao = candidateApprovalDao;
        this.candidateDao = candidateDao;
        this.usersDao = usersDao;
    }


    public static String GenerateVerificationCode(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        StringBuilder verificationCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            verificationCode.append(characters.charAt(randomIndex));
        }
        return verificationCode.toString();
    }

    @Override
    public Result verifyEmail(String email, String userCode) {
        Candidate candidate = usersDao.getCandidateByEmail(email);
        CandidateApproval candidateApproval = candidateApprovalDao.getCandidateApprovalById(candidate.getId());

        if (candidate.is_verified()==true)
            return new SuccessResult("Email is already verified.");

        if (userCode.equals(candidateApproval.getCode())){
            candidateApproval.set_verified(true);
            candidate.set_verified(true);

            candidateApprovalDao.save(candidateApproval);
            candidateDao.save(candidate);
            return new SuccessResult("Email is verified.");
        }

        return new ErrorResult("Wrong verification code.");
    }
}