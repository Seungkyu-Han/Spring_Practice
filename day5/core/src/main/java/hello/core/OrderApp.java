package hello.core;

import hello.core.customer.Customer;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import hello.core.customer.Grade;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long id = 1L;
        Customer customer = new Customer(id, "seungkyu", Grade.VIP);
        customerService.join(customer);

        Order order = orderService.createOrder(id, "Latte", 10000);

        System.out.println("order = " + order);
    }
}
