package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.dataAccess.abstracts.cvDao.CoverLetterDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Users;
import com.example.hrms.entities.concretes.candidateResume.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;
    private UsersDao usersDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao, UsersDao usersDao) {
        this.coverLetterDao = coverLetterDao;
        this.usersDao = usersDao;
    }

    @Override
    public Result addByMail(String email, String password, CoverLetter coverLetter){
        Candidate candidate = usersDao.getCandidateByEmail(email);
        if (candidate.getPassword().equals(password) ){
            coverLetter.setCandidate(candidate);
            this.coverLetterDao.save(coverLetter);
            return new SuccessResult("Cover Letter added.");
        }
        return new ErrorResult("Email and password dont match.");
    }

    @Override
    public Result add(CoverLetter coverLetter) {
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("Cover Letter added.");
    }
}
