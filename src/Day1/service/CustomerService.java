package Day1.service;

import Day1.model.Customer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerService {

    public List<Customer> getActiveCustomers(List<Customer> customers) {
        return customers.stream()
                .filter(Customer::isActive)
                .toList();
    }

    public List<String> getCustomerNames(List<Customer> customers) {
        return customers.stream()
                .map(Customer::getName)
                .toList();
    }

    public List<String> getActiveCustomerNames(List<Customer> customers) {
        return customers.stream()
                .filter(Customer::isActive)
                .map(Customer::getName)
                .toList();
    }

    public Map<String, List<Customer>> groupCustomersByCountry(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getCountry));
    }

    public long countActiveCustomers(List<Customer> customers) {
        return customers.stream()
                .filter(Customer::isActive)
                .count();
    }
}
