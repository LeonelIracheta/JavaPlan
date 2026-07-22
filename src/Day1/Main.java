package Day1;

import Day1.model.Customer;
import Day1.service.CustomerService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        Set<Customer> customerUnics = new HashSet<>();

        Customer customer1 = new Customer("Rene","Mexico",true);

        customerUnics.add(customer1);
        customerUnics.add(customer1);

        System.out.println(customerUnics.size());


        customers.add(new Customer("Leo", "Mexico", true));
        customers.add(new Customer("John", "USA", false));
        customers.add(new Customer("Maria", "Mexico", true));
        customers.add(new Customer("Ana", "Spain", true));
        customers.add(new Customer("Mike", "USA", false));

        for (Customer customer: customerUnics){
            System.out.println(customer.getName());
        }

        customerUnics.forEach(customer -> System.out.println(customer.getName()));

        CustomerService customerService = new CustomerService();

        System.out.println("Active customers:");
        customerService.getActiveCustomers(customers)
                .forEach(System.out::println);

        System.out.println("\nCustomer names:");
        customerService.getCustomerNames(customers)
                .forEach(System.out::println);

        System.out.println("\nActive customer names:");
        customerService.getActiveCustomerNames(customers)
                .forEach(System.out::println);

        System.out.println("\nCustomers grouped by country:");

        Map<String, List<Customer>> customersByCountry =
                customerService.groupCustomersByCountry(customers);

        customersByCountry.forEach((country, customerList) -> {
            System.out.println(country + ":");
            customerList.forEach(System.out::println);
        });

        long activeCount = customerService.countActiveCustomers(customers);

        System.out.println("\nActive customers count: " + activeCount);
    }
}
