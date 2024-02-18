package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobAdvertisementService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CompanyDao;
import com.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.dataAccess.abstracts.UsersDao;
import com.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private UsersDao usersDao;
    private CompanyDao companyDao;
    private JobDao jobDao;

    @Autowired

    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, UsersDao usersDao, CompanyDao companyDao, JobDao jobDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.usersDao = usersDao;
        this.companyDao = companyDao;
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisements() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatusTrue(), "All active Jobs are listed.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByStatusTrueOrderByApplicationStart() {
        var result = jobAdvertisementDao.findByStatusTrueOrderByApplicationStart();
        return new SuccessDataResult<List<JobAdvertisement>>(result, "All jobs are listed.");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("New Job added.");
    }

    @Override
    public Result setStatusFalse(int jobAdvertisementId){
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.findJobAdvertisementById(jobAdvertisementId);
        jobAdvertisement.setStatus(false);

        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("Job advertisement status changed to false.");
    }



}
