package com.nemal.JobAppMicro.company.repositories;

import com.nemal.JobAppMicro.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
