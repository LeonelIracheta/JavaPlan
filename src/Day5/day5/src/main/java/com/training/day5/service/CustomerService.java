package com.training.day5.service;

import com.training.day5.model.Customer;
import com.training.day5.dto.CustomerRequest;
import com.training.day5.dto.CustomerResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public CustomerService() {

        customers.add(
                new Customer(
                        1L,
                        "Leonel",
                        "leo@test.com",
                        "INT-001"
                ));
    }

    public List<CustomerResponse> getAllCustomers() {

        return customers.stream()
                .map(this::toResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(Long id) {

        Customer customer = customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();

        return toResponse(customer);
    }

    public CustomerResponse createCustomer(CustomerRequest request) {

        Customer customer = new Customer(
                (long) (customers.size() + 1),
                request.getName(),
                request.getEmail(),
                "INT-" + (customers.size() + 1)
        );

        customers.add(customer);

        return toResponse(customer);
    }

    private CustomerResponse toResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        return response;
    }
}