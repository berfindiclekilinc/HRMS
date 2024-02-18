package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Company;
import com.example.hrms.entities.concretes.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersDao extends JpaRepository<Users,Integer> {

    boolean existsByEmail(String email);

    Candidate getCandidateByEmail(String email);

    Company getCompanyByEmail(String email);
}

