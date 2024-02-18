package com.example.hrms.dataAccess.abstracts.cvDao;


import com.example.hrms.entities.concretes.candidateResume.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
}
