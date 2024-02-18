package com.example.hrms.business.abstracts.cvAbstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;

import com.example.hrms.entities.concretes.candidateResume.Education;

import java.util.List;

public interface EducationService {

    Result add(Education education);

}
