package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyVerificationService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CompanyApprovalDao;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;

import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.CompanyApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CompanyVerificationManager implements CompanyVerificationService {

    private CompanyApprovalDao companyApprovalDao;
    private CompanyDao companyDao;
    private UsersDao usersDao;

    @Autowired
    public CompanyVerificationManager(CompanyApprovalDao companyApprovalDao, CompanyDao companyDao, UsersDao usersDao) {
        this.companyApprovalDao = companyApprovalDao;
        this.companyDao = companyDao;
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
        Company company = usersDao.getCompanyByEmail(email);
        CompanyApproval companyApproval = companyApprovalDao.getCompanyApprovalById(company.getId());

        if (company.is_mail_verified())
            return new SuccessResult("Email is already verified.");

        if (userCode.equals(companyApproval.getCode())){
            companyApproval.set_verified(true);
            company.set_mail_verified(true);

            companyApprovalDao.save(companyApproval);
            companyDao.save(company);
            return new SuccessResult("Email is verified.");
        }

        return new ErrorResult("Wrong verification code.");
    }



}
