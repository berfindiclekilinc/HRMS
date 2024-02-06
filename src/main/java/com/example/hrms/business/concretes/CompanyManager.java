package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    private UsersDao usersDao;

    @Autowired
    public CompanyManager(CompanyDao companyDao, UsersDao usersDao) {
        super();
        this.companyDao = companyDao;
        this.usersDao = usersDao;
    }

    @Override
    public DataResult<List<Company>> getAll() {
        return new SuccessDataResult<List<Company>>
                (this.companyDao.findAll(), "Companies Listed.");
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


    public Result add(Company company){

        if (!isCompanyMail(company)){
            return new ErrorResult("Email is not a company Email.");
        }

        if (isEmailAlreadyInUse(company)) {
            return new ErrorResult("Email is already in use.");
        }

        this.companyDao.save(company);
        return new SuccessResult("New Company added.");

    }

}
