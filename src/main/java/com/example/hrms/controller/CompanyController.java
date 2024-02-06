package com.example.hrms.controller;

import com.example.hrms.business.abstracts.CompanyService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Company>> getAll(){
        return this.companyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Company company){
        return this.companyService.add(company);
    }

}