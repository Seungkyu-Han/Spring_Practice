package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.customer.CustomerRepository;
import hello.core.customer.CustomerServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void ConfigurationTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerServiceImpl customerService = applicationContext.getBean("customerService", CustomerServiceImpl.class);
        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);
        CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);

        Assertions.assertSame(customerService.customerRepository(), customerRepository);
        Assertions.assertSame(orderService.customerRepository(), customerRepository);
    }
}
