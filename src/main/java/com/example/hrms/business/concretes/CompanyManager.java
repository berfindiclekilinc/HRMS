package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CompanyApprovalDao;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateApproval;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.CompanyApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.hrms.business.concretes.CandidateVerificationManager.GenerateVerificationCode;

@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    private UsersDao usersDao;
    private CompanyApprovalDao companyApprovalDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao, UsersDao usersDao, CompanyApprovalDao companyApprovalDao) {
        super();
        this.companyDao = companyDao;
        this.usersDao = usersDao;
        this.companyApprovalDao = companyApprovalDao;
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>
                (this.companyDao.findAll(), "Companies Listed.");
    }

    private void isNotNull(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("Company cannot be null.");
        }
        if (company.getCompanyName().isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be blank or null.");
        }
        if (company.getWebsite().isEmpty()) {
            throw new IllegalArgumentException("Company mail cannot be blank or null.");
        }
        if (company.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be blank or null.");
        }
    }


    public boolean isCompanyMail(Company company){
        String email = company.getEmail();
        String[] parts = email.split("@");
        String domain = parts[1].toLowerCase();

        return (company.getWebsite().equalsIgnoreCase(domain));
    }

    public boolean isEmailAlreadyInUse(Company company) {
        return usersDao.existsByEmail(company.getEmail());
    }

    private void addVerificationCode(Company company){
        CompanyApproval companyApproval = new CompanyApproval();

        companyApproval.setId(company.getId());
        companyApproval.setCode(GenerateVerificationCode());
        companyApproval.set_verified(false);

        companyApprovalDao.save(companyApproval);
    }

    public Result add(Company company){

        try {
            if (!isCompanyMail(company)) {
                return new ErrorResult("Email is not a company Email.");
            }

            if (isEmailAlreadyInUse(company)) {
                return new ErrorResult("Email is already in use.");
            }

            this.companyDao.save(company);
            addVerificationCode(company);

            return new SuccessResult("New Company added.");
        }
        catch (IllegalArgumentException e){
            return new ErrorResult(e.getMessage());
        }

    }
}
