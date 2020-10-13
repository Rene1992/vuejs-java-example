package com.bbtutorials.customers.repository;

import com.bbtutorials.customers.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface CustomersRepository extends JpaRepository<Customers, Integer>, JpaSpecificationExecutor<Customers>, QuerydslPredicateExecutor<Customers> {}
