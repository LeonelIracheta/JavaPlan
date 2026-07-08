package com.day4.app.service;

import com.day4.app.model.Customer;
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
                        "leonel@email.com"
                ));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(Long id) {

        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Customer createCustomer(Customer customer) {

        customers.add(customer);

        return customer;
    }

    public Customer updateCustomer(
            Long id,
            Customer updatedCustomer) {

        Customer customer = getCustomerById(id);

        if (customer != null) {

            customer.setName(
                    updatedCustomer.getName());

            customer.setEmail(
                    updatedCustomer.getEmail());
        }

        return customer;
    }

    public void deleteCustomer(Long id) {

        customers.removeIf(
                customer ->
                        customer.getId().equals(id));
    }
}
