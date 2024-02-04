package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private UsersDao usersDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UsersDao usersDao){
        super();
        this.candidateDao = candidateDao;
        this.usersDao = usersDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(), "Candidates Listed.");
    }

    public boolean isEmailAlreadyInUse(Candidate candidate) {
        return usersDao.existsByEmail(candidate.getEmail());
    }

    public boolean isTcAlreadyInUse(Candidate candidate){
        return candidateDao.existsByTc(candidate.getTc());
    }

    private void validateCandidate(Candidate candidate) {
        if (candidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null.");
        }
        if (candidate.getFirstName()=="") {
            throw new IllegalArgumentException("First name cannot be blank or null.");
        }
        if (candidate.getLastName()=="") {
            throw new IllegalArgumentException("Last name cannot be blank or null.");
        }
        if (candidate.getTc()=="") {
            throw new IllegalArgumentException("TC cannot be blank or null.");
        }
        if (candidate.getEmail()=="") {
            throw new IllegalArgumentException("Email cannot be blank or null.");
        }
        if (candidate.getPassword()=="") {
            throw new IllegalArgumentException("Password cannot be blank or null.");
        }
        if (candidate.getBirthYear()==null) {
            throw new IllegalArgumentException("Birth year cannot be blank or null.");
        }
    }

    @Override
    public Result add(Candidate candidate) {

        try {
            validateCandidate(candidate);

            if (isEmailAlreadyInUse(candidate)) {
                return new ErrorResult("Email is already in use.");
            }

            if (isTcAlreadyInUse(candidate)) {
                return new ErrorResult("TC number is already in use.");
            }

            this.candidateDao.save(candidate);
            return new SuccessResult("New Candidate added.");
        } catch (IllegalArgumentException e) {
            return new ErrorResult(e.getMessage());
        }

    }
}
