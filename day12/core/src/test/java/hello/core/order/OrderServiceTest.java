package hello.core.order;

import hello.core.AppConfig;
import hello.core.customer.Customer;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import hello.core.customer.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    CustomerService customerService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        customerService = appConfig.customerService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long id = 1L;
        Customer customer = new Customer(id, "Seungkyu", Grade.VIP);
        customerService.join(customer);

        Order order = orderService.createOrder(id, "Latte", 10000);
        Assertions.assertEquals(500, order.getDiscountPrice());
    }

}
