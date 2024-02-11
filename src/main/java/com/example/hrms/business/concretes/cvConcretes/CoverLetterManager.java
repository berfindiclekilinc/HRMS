package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.cvDao.CoverLetterDao;
import com.example.hrms.entities.concretes.candidateResume.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }


    @Override
    public Result add(CoverLetter coverLetter) {
        return null;
    }
}
