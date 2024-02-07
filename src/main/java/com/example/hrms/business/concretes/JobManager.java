package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobManager implements JobService {

    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao){
        super();
        this.jobDao = jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<List<Job>>
                (this.jobDao.findAll(), "Jobs Listed.");
    }

    public boolean isPositionExist(Job job) {
        return jobDao.existsByCompIdAndTitle(job.getCompId(), job.getTitle());
    }

    private Result isExist(Job job) {
        if (isPositionExist(job)) {
            return new ErrorResult("Job position already exists.");
        }

        return null;
    }

    private void isNotNull(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null.");
        }
        if (job.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank or null.");
        }
        if (job.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Job description cannot be blank or null.");
        }
        if (job.getCompId() == null) {
            throw new IllegalArgumentException("TC cannot be blank or null.");
        }
    }


    @Override
    public Result add(Job job) {
        Result result = isExist(job);
        if (result != null) {
            return result;
        }

        this.jobDao.save(job);
        return new SuccessResult("New Job Added.");
    }
}
