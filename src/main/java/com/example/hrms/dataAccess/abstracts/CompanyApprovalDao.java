package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CompanyApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyApprovalDao extends JpaRepository<CompanyApproval, Integer> {

    CompanyApproval getCompanyApprovalById(Integer id);
}
