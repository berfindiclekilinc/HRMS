package com.example.hrms.controller;

import com.example.hrms.business.abstracts.StaffService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        super();
        this.staffService = staffService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Staff>> getAll(){
        return this.staffService.getAll();
    }



}
