package com.bbtutorials.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bbtutorials.customers.entity.Companies;

@RepositoryRestResource()
public interface CompaniesRepository extends JpaRepository<Companies, Integer>, JpaSpecificationExecutor<Companies>, QuerydslPredicateExecutor<Companies> {}
