package Day3.service;

import Day3.exception.NotFoundException;
import Day3.exception.ValidationException;
import Day3.model.Customer;

public class CustomerService {

    public Customer findCustomer(Long id) {

        if (id == null) {
            throw new ValidationException("Customer id cannot be null");
        }

        if (id != 1L) {
            throw new NotFoundException("Customer not found: " + id);
        }

        return new Customer(1L, "Leo");
    }
}
