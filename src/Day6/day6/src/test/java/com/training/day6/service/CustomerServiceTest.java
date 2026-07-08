package com.training.day6.service;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.day6.dto.CustomerRequest;
import com.training.day6.dto.CustomerResponse;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void shouldReturnAllCustomers() {

        List<CustomerResponse> customers =
                customerService.getAllCustomers();

        assertNotNull(customers);
        assertEquals(1, customers.size());

        assertEquals(
                "Leonel",
                customers.get(0).getName());
    }

    @Test
    void shouldReturnCustomerById() {

        CustomerResponse customer =
                customerService.getCustomerById(1L);

        assertNotNull(customer);

        assertEquals(
                1L,
                customer.getId());

        assertEquals(
                "Leonel",
                customer.getName());

        assertEquals(
                "leo@test.com",
                customer.getEmail());
    }

    @Test
    void shouldThrowExceptionWhenCustomerDoesNotExist() {

        assertThrows(
                NoSuchElementException.class,
                () -> customerService.getCustomerById(999L)
        );
    }

    @Test
    void shouldCreateCustomer() {

        CustomerRequest request =
                new CustomerRequest();

        request.setName("John");
        request.setEmail("john@test.com");

        CustomerResponse response =
                customerService.createCustomer(request);

        assertNotNull(response);

        assertEquals(
                "John",
                response.getName());

        assertEquals(
                "john@test.com",
                response.getEmail());
    }

    @Test
    void shouldIncreaseCustomerCountAfterCreation() {

        CustomerRequest request =
                new CustomerRequest();

        request.setName("Maria");
        request.setEmail("maria@test.com");

        customerService.createCustomer(request);

        List<CustomerResponse> customers =
                customerService.getAllCustomers();

        assertEquals(
                2,
                customers.size());
    }
}