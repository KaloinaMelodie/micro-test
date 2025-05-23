package com.example.client.mapper;

import com.example.client.dto.CustomerMirrorDto;
import com.example.client.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerMirrorDto customerMirrorDto) {
        return new Customer(customerMirrorDto.getId(),customerMirrorDto.getFirstName(),customerMirrorDto.getLastName(),customerMirrorDto.getEmail());
    }
    public CustomerMirrorDto toCustomerMirrorDto(Customer customer) {
        return new CustomerMirrorDto(customer.getId(),customer.getFirstName(),customer.getLastName(),customer.getEmail());
    }
    public List<CustomerMirrorDto> toCustomerMirrorDtoList(List<Customer> customerList) {
        return customerList.stream().map(this::toCustomerMirrorDto).collect(Collectors.toList());
    }
}
