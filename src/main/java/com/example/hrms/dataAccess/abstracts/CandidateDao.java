package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsByTc(String tc);

    Candidate getById(int candidateId);
}
