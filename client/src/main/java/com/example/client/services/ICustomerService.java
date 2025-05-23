package com.example.client.services;

import com.example.client.dto.CustomerMirrorDto;
import com.example.client.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerMirrorDto> getAll();
    CustomerMirrorDto getById(Long id);
}
