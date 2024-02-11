package com.example.hrms.dataAccess.abstracts.cvDao;


import com.example.hrms.entities.concretes.candidateResume.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
