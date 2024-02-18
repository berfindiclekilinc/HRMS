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


    @Override
    public Result verifyEmail(String email, String userCode) {
        Candidate candidate = usersDao.getCandidateByEmail(email);
        CandidateApproval candidateApproval = candidateApprovalDao.getCandidateApprovalById(candidate.getId());

        if (candidate.is_verified())
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