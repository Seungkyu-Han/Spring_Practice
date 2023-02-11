package hello.core;

import hello.core.customer.Customer;
import hello.core.customer.CustomerService;
import hello.core.customer.Grade;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();

        //CustomerService customerService = appConfig.customerService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long id = 1L;
        Customer customer = new Customer(id, "seungkyu", Grade.VIP);
        customerService.join(customer);

        Order order = orderService.createOrder(id, "Latte", 10000);

        System.out.println("order = " + order);
    }
}
