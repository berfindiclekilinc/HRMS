package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;

public interface CandidateVerificationService {
    Result verifyEmail(String email, String userCode);
}
