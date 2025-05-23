package com.example.client.controller;


import com.example.client.dto.CustomerMirrorDto;
import com.example.client.entities.Customer;
import com.example.client.repositories.CustomerRepository;
import com.example.client.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<CustomerMirrorDto> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/customer/{id}")
    public CustomerMirrorDto getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

}
