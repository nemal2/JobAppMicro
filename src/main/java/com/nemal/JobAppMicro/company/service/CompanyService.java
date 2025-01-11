package com.nemal.JobAppMicro.company.service;

import com.nemal.JobAppMicro.company.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
}
