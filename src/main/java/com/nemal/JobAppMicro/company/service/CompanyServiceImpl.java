package com.nemal.JobAppMicro.company.service;

import com.nemal.JobAppMicro.company.model.Company;
import com.nemal.JobAppMicro.company.repositories.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional <Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
        Company company1 = optionalCompany.get();
        company1.setName(company.getName());
        company1.setDescription(company.getDescription());
        companyRepository.save(company1);
        return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
}
