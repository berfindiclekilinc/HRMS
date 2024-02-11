package com.example.hrms.business.concretes.cvConcretes;

import com.example.hrms.business.abstracts.cvAbstracts.WebAddressService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.dataAccess.abstracts.cvDao.WebAddressDao;
import com.example.hrms.entities.concretes.candidateResume.WebAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebAddressManager implements WebAddressService {

    private WebAddressDao webAddressDao;

    @Autowired
    public WebAddressManager(WebAddressDao webAddressDao) {
        this.webAddressDao = webAddressDao;
    }

    @Override
    public Result add(WebAddress webAddress) {
        return null;
    }
}
