package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UsersDao usersDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UsersDao usersDao) {
        super();
        this.employerDao = employerDao;
        this.usersDao = usersDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>
                (this.employerDao.findAll(), "Employers Listed.");
    }

    public boolean isCompanyMail(Employer employer){
        String email = employer.getEmail();
        String[] parts = email.split("@");
        String domain = parts[1].toLowerCase();

        return (employer.getWebsite().equalsIgnoreCase(domain));
    }

    public boolean isEmailAlreadyInUse(Employer employer) {
        return usersDao.existsByEmail(employer.getEmail());
    }


    public Result add(Employer employer){

        if (!isCompanyMail(employer)){
            return new ErrorResult("Email is not a company Email.");
        }

        if (isEmailAlreadyInUse(employer)) {
            return new ErrorResult("Email is already in use.");
        }

        this.employerDao.save(employer);
        return new SuccessResult("New Employer added.");

    }

}
