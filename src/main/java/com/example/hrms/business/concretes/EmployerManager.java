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
        domain = domain.substring(0, domain.length() - 4);

        return (employer.getCompanyName().equalsIgnoreCase(domain));

    }

    public Result add(Employer employer){

        if (!isCompanyMail(employer)){
            return new ErrorResult("Email is not a company Email.");
        }

        this.employerDao.save(employer);
        return new SuccessResult("New Employer added.");

    }

}
