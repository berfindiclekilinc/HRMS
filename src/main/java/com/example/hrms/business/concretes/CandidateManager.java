package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateApprovalDao;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hrms.business.concretes.CandidateVerificationManager.GenerateVerificationCode;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final UsersDao usersDao;
    private final CandidateApprovalDao candidateApprovalDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UsersDao usersDao, CandidateApprovalDao candidateApprovalDao) {
        super();
        this.candidateDao = candidateDao;
        this.usersDao = usersDao;
        this.candidateApprovalDao = candidateApprovalDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll(), "Candidates Listed.");
    }

    public boolean isEmailAlreadyInUse(Candidate candidate) {
        return usersDao.existsByEmail(candidate.getEmail());
    }

    public boolean isTcAlreadyInUse(Candidate candidate) {
        return candidateDao.existsByTc(candidate.getTc());
    }

//    public boolean isPasswordSame(Candidate candidate){
//        return candidate.getPasswordVerify().equals(candidate.getPassword());
//    }

    private void isNotNull(Candidate candidate) {
        if (candidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null.");
        }
        if (candidate.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be blank or null.");
        }
        if (candidate.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be blank or null.");
        }
        if (candidate.getTc().isEmpty()) {
            throw new IllegalArgumentException("TC cannot be blank or null.");
        }
        if (candidate.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be blank or null.");
        }
        if (candidate.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be blank or null.");
        }
        if (candidate.getBirthYear() == null) {
            throw new IllegalArgumentException("Birth year cannot be blank or null.");
        }
    }

    private Result isExist(Candidate candidate) {
        if (isEmailAlreadyInUse(candidate)) {
            return new ErrorResult("Email is already in use.");
        }

        if (isTcAlreadyInUse(candidate)) {
            return new ErrorResult("TC number is already in use.");
        }

//        if (!isPasswordSame(candidate)){
//            return new ErrorResult("Passwords don't match.");
//        }

        return null;
    }

    private void addVerificationCode(Candidate candidate){
        CandidateApproval candidateApproval = new CandidateApproval();

        candidateApproval.setId(candidate.getId());
        candidateApproval.setCode(GenerateVerificationCode());
        candidateApproval.set_verified(false);

        candidateApprovalDao.save(candidateApproval);
    }

    @Override
    public Result add(Candidate candidate) {
        try {
            isNotNull(candidate);
            isExist(candidate);

            Result result = isExist(candidate);
            if (result != null) {
                return result;
            }

            this.candidateDao.save(candidate);
            addVerificationCode(candidate);

            return new SuccessResult("New Candidate added.");
        } catch (IllegalArgumentException e) {
            return new ErrorResult(e.getMessage());
        }
    }
}
