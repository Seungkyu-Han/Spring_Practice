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
    void configurationTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerServiceImpl customerService = applicationContext.getBean("customerService", CustomerServiceImpl.class);

        OrderServiceImpl orderService = applicationContext.getBean("orderService", OrderServiceImpl.class);

        CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);
        CustomerRepository customerRepository1 = customerService.getCustomerRepository();
        CustomerRepository customerRepository2 = orderService.getCustomerRepository();


        System.out.println("customerService -> customerRepository = " + customerRepository1);
        System.out.println("orderService -> customerRepository = " + customerRepository2);
        System.out.println("customerRepository = " + customerRepository);

        Assertions.assertSame(orderService.getCustomerRepository(), customerService.getCustomerRepository());
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
