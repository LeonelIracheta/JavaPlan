package Day3;

import Day3.exception.BusinessException;
import Day3.exception.NotFoundException;
import Day3.exception.ValidationException;
import Day3.model.Customer;
import Day3.service.CustomerService;

public class Main {

    public static void main(String[] args) {

        CustomerService service = new CustomerService();

        try {

            Customer customer = service.findCustomer(5L);
            System.out.println(customer.getName());

        } catch (ValidationException ex) {

            System.out.println("Validation error: " + ex.getMessage());

        } catch (NotFoundException ex) {

            System.out.println("Not found: " + ex.getMessage());

        } catch (BusinessException ex) {

            System.out.println("Business error: " + ex.getMessage());

        }
    }
}
