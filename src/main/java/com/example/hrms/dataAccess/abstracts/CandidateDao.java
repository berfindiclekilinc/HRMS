package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateApproval;
import com.example.hrms.entities.dtos.CandidateResumeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsByTc(String tc);

    Candidate getById(int candidateId);

    @Query("SELECT new com.example.hrms.entities.dtos.CandidateResumeDto(c.id, c.firstName, c.lastName, e.department, e.schoolName, e.startYear, e.endYear, ex.company, ex.position, ex.jobStartYear, ex.jobEndYear, l.languageLevel, l.languageName, s.knownTechnology, w.linkedin, w.github, c.candidateCoverLetter.coverLetter) " +
            "FROM Candidate c " +
            "LEFT JOIN c.candidateEducation e " +
            "LEFT JOIN c.candidateExperience ex " +  // Changed candidateExperience to ex
            "LEFT JOIN c.candidateLanguage l " +
            "LEFT JOIN c.candidateSkill s " +
            "LEFT JOIN c.candidateWebAddress w")
    List<CandidateResumeDto> getCandidateFullCv();

}
