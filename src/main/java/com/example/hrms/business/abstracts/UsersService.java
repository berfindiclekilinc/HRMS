package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.Users;

import java.util.List;

public interface UsersService {
    List<Users> getAll();
}
