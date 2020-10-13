package com.bbtutorials.customers.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bbtutorials.customers.entity.Customers;
import com.bbtutorials.customers.repository.CustomersRepository;

@Component
public class CustomersService {
	
    private CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> getCustomers() {
        return customersRepository.findAll();
    }
    
    public Customers saveCustomer(Customers customers) {
    	return customersRepository.save(customers);
    }

    public List<Customers> deleteCustomer(Customers customer) {
        customersRepository.delete(customer);
        return customersRepository.findAll();
    }

    public List<Customers> saveAllCustomers(List<Customers> customers) {
        return customersRepository.saveAll(customers);
    }

}
