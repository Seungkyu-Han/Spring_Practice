package hello.core;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.RateDiscountPolicy;
import hello.core.customer.CustomerRepository;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import hello.core.customer.MemoryCustomerRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService(){
        System.out.println("call AppConfig.customerService");
        return new CustomerServiceImpl(customerRepository());
    }

    @Bean
    public CustomerRepository customerRepository(){
        System.out.println("call AppConfig.customerRepository");
        return new MemoryCustomerRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(customerRepository() , discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
