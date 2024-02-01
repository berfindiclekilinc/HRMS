package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.StaffService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.StaffDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {

    private StaffDao staffDao;
    private UsersDao usersDao;

    @Autowired
    public StaffManager(StaffDao staffDao, UsersDao usersDao) {
        super();
        this.staffDao = staffDao;
        this.usersDao = usersDao;
    }

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<List<Staff>>
                (this.staffDao.findAll(), "Staff Listed.");
    }
}
