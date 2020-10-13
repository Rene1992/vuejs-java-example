package com.bbtutorials.customers.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bbtutorials.customers.entity.Companies;
import com.bbtutorials.customers.repository.CompaniesRepository;

@Component
public class CompaniesService {
	
    private CompaniesRepository companiesRepository;

    public CompaniesService(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    public List<Companies> getCompanies() {
        return companiesRepository.findAll();
    }
    
}
