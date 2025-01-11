package com.nemal.JobAppMicro.company.controller;

import com.nemal.JobAppMicro.company.model.Company;
import com.nemal.JobAppMicro.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    ResponseEntity <List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    ResponseEntity <String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean ans = companyService.updateCompany(company,id);

        if (!ans) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
    }

    @PostMapping
    ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
}
