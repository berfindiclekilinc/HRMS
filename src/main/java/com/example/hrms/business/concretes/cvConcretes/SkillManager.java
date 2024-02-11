package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.SkillService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.cvDao.SkillDao;
import com.example.hrms.entities.concretes.candidateResume.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        return null;
    }
}
