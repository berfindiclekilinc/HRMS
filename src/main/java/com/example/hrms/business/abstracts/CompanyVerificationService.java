package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;

public interface CompanyVerificationService {

    Result verifyEmail(String email, String userCode);
}
