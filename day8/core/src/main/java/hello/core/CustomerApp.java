package hello.core;

import hello.core.customer.Customer;
import hello.core.customer.CustomerService;
import hello.core.customer.Grade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        Customer customer = new Customer(1L, "Seungkyu", Grade.VIP);

        customerService.join(customer);

        Customer findCustomer = customerService.findCustomer(1L);
        System.out.println("new customer = " + customer.getName());
        System.out.println("find customer = " + findCustomer.getName());
    }
}
