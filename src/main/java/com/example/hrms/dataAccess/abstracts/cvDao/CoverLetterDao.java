package com.example.hrms.dataAccess.abstracts.cvDao;

import com.example.hrms.entities.concretes.candidateResume.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
}
