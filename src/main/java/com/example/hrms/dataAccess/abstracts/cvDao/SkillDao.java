package com.example.hrms.dataAccess.abstracts.cvDao;


import com.example.hrms.entities.concretes.candidateResume.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill, Integer> {
}
