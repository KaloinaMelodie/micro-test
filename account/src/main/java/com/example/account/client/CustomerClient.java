package com.example.account.client;

import com.example.account.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER")
public interface CustomerClient {
    @GetMapping("/customer")
    @CircuitBreaker(name = "customers", fallbackMethod = "getAllCustomers")
    List<Customer> getAll();

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomer")
    Customer getById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception exception)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");
        return customer;
    }
    default List<Customer> getAllCustomers(Exception exception)
    {
        return List.of();
    }
}
