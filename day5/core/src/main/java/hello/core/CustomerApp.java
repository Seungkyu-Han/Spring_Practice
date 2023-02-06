package hello.core;

import hello.core.customer.Customer;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import hello.core.customer.Grade;

public class CustomerApp {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();

        Customer customer = new Customer(1L, "Seungkyu", Grade.VIP);

        customerService.join(customer);

        Customer findCustomer = customerService.findCustomer(1L);
        System.out.println("new customer = " + customer.getName());
        System.out.println("find customer = " + findCustomer.getName());
    }
}
