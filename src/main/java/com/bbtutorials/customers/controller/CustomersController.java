package com.bbtutorials.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.customers.entity.Customers;
import com.bbtutorials.customers.entity.Companies;
import com.bbtutorials.customers.links.CustomerLinks;
import com.bbtutorials.customers.service.CustomersService;
import com.bbtutorials.customers.service.CompaniesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class CustomersController {
	
	@Autowired
    CustomersService customersService;
    
    @Autowired
	CompaniesService companiesService;
	
	@GetMapping(path = CustomerLinks.LIST_CUSTOMERS)
    public ResponseEntity<?> listCustomers() {
        List<Customers> resource = customersService.getCustomers();
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = CustomerLinks.LIST_COMPANIES)
    public ResponseEntity<?> listCompanies() {
        List<Companies> resource = companiesService.getCompanies();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = CustomerLinks.DELETE_CUSTOMER)
	public ResponseEntity<?> deleteCustomer(@RequestBody Customers customer) {
        List<Customers> resource = customersService.deleteCustomer(customer);
        return ResponseEntity.ok(resource);
    }
	
	@PostMapping(path = CustomerLinks.ADD_CUSTOMER)
	public ResponseEntity<?> saveCustomer(@RequestBody Customers customer) {
        Customers resource = customersService.saveCustomer(customer);
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = CustomerLinks.SAVE_ALL_CUSTOMERS)
	public ResponseEntity<?> saveAllCustomers(@RequestBody List<Customers> customers) {
        List<Customers> resource = customersService.saveAllCustomers(customers);
        return ResponseEntity.ok(resource);
    }
}
