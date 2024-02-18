package com.example.hrms.business.abstracts.cvAbstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.candidateResume.Skill;

import java.util.List;

public interface SkillService {

    Result add(Skill skill);
}
