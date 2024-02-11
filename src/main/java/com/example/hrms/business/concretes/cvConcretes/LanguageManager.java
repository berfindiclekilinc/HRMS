package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.LanguageService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.cvDao.LanguageDao;
import com.example.hrms.entities.concretes.candidateResume.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        return null;
    }
}
