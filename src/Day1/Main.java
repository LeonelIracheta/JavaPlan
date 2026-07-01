package Day1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Leo", "Mexico", true));
        customers.add(new Customer("John", "USA", false));
        customers.add(new Customer("Maria", "Mexico", true));
        customers.add(new Customer("Ana", "Spain", true));
        customers.add(new Customer("Mike", "USA", false));

        // filter active customers
        List<Customer> activeCustomers = customers.stream()
                .filter(Customer::isActive)
                .toList();
        System.out.println("Active customers:");
        activeCustomers.forEach(System.out::println);

        // customers name
        List<String> names = customers.stream()
                .map(Customer::getName)
                .toList();
        System.out.println("\nCustomer names:");
        names.forEach(System.out::println);

        // active customers name
        List<String> activeNames = customers.stream()
                .filter(Customer::isActive)
                .map(Customer::getName)
                .toList();
        System.out.println("\nActive customer names:");
        activeNames.forEach(System.out::println);

        // customers grouped by country
        Map<String, List<Customer>> customersByCountry = customers.stream()
                .collect(Collectors.groupingBy(Customer::getCountry));
        System.out.println("\nCustomers grouped by country:");
        customersByCountry.forEach((country, customerList) -> {
            System.out.println(country + ":");
            customerList.forEach(System.out::println);
        });

        // count active customers
        long activeCount = customers.stream()
                .filter(Customer::isActive)
                .count();
        System.out.println("\nActive customers count: " + activeCount);
    }
}
