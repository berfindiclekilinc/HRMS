package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CandidateApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateApprovalDao extends JpaRepository<CandidateApproval, Integer> {

    CandidateApproval getCandidateApprovalById(Integer id);
}
