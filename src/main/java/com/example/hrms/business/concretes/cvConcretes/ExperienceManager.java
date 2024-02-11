package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.ExperienceService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.cvDao.ExperienceDao;
import com.example.hrms.entities.concretes.candidateResume.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }
    @Override
    public Result add(Experience experience) {
        return null;
    }
}
