package com.example.hrms.dataAccess.abstracts.cvDao;

import com.example.hrms.entities.concretes.candidateResume.WebAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebAddressDao extends JpaRepository<WebAddress, Integer> {
}
