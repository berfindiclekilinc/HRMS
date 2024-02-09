package com.example.hrms.controller;


import com.example.hrms.business.abstracts.UsersService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Users>> getAll(){
        return this.usersService.getAll();
    }

}
