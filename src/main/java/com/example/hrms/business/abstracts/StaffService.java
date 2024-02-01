package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Job;
import com.example.hrms.entities.concretes.Staff;

import java.util.List;

public interface StaffService {
    DataResult<List<Staff>> getAll();
}
