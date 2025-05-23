package com.example.client.services;

import com.example.client.dto.CustomerMirrorDto;
import com.example.client.entities.Customer;
import com.example.client.mapper.CustomerMapper;
import com.example.client.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerMirrorDto> getAll() {
        return customerMapper.toCustomerMirrorDtoList(customerRepository.findAll());
    }

    @Override
    public CustomerMirrorDto getById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null) {
            return customerMapper.toCustomerMirrorDto(customer);
        }
        return null;
    }
}
