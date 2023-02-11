package hello.core.order;

import hello.core.Discount.FixDiscountPolicy;
import hello.core.customer.Customer;
import hello.core.customer.Grade;
import hello.core.customer.MemoryCustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryCustomerRepository customerRepository = new MemoryCustomerRepository();
        customerRepository.save(new Customer(1L, "hello", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(customerRepository, new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }

}