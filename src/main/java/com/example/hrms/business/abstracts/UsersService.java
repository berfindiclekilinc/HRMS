package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Users;

import java.util.List;

public interface UsersService {
    DataResult<List<Users>> getAll();
}
