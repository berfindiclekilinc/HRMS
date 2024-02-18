package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Integer> {
}
