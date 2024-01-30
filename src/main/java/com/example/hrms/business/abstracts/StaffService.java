package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAll();
}
