package com.danieljr.testcontainers.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieljr.testcontainers.demo.dto.Customer;
import com.danieljr.testcontainers.demo.repository.CustomerDbModel;
import com.danieljr.testcontainers.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        List<CustomerDbModel> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(this::createCustomer)
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(String customerId) {
        final CustomerDbModel customerDbModel = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found by id: " + customerId));
        return createCustomer(customerDbModel);
    }

    public Customer saveCustomer(Customer customer) {
        final CustomerDbModel savedCustomer = customerRepository.save(createCustomerDbModel(customer));
        return createCustomer(savedCustomer);
    }

    private CustomerDbModel createCustomerDbModel(Customer customer) {
        return CustomerDbModel.builder()
                ._id(null)
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .build();
    }

    private Customer createCustomer(CustomerDbModel customerDbModel) {
        return Customer.builder()
                .customerId(customerDbModel.get_id())
                .firstName(customerDbModel.getFirstName())
                .lastName(customerDbModel.getLastName())
                .age(customerDbModel.getAge())
                .build();
    }
}
