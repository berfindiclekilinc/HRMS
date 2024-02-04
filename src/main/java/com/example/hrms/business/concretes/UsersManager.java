package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UsersService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersManager implements UsersService {

    private UsersDao usersDao;

    @Autowired
    public UsersManager(UsersDao usersDao) {
        super();
        this.usersDao = usersDao;
    }

    @Override
    public DataResult<List<Users>> getAll() {
        return new SuccessDataResult<List<Users>>
                (this.usersDao.findAll(), "Users Listed.");
    }
}
