package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvertisement;

import javax.xml.crypto.Data;
import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisements();

    Result add(JobAdvertisement jobAdvertisement);
}
