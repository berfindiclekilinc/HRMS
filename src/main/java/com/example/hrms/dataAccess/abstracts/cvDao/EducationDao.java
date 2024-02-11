package com.example.hrms.dataAccess.abstracts.cvDao;

import com.example.hrms.entities.concretes.candidateResume.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education, Integer> {
}
