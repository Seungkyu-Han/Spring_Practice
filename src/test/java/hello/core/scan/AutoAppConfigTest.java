package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        CustomerService customerService = applicationContext.getBean(CustomerServiceImpl.class);
        Assertions.assertInstanceOf(CustomerService.class, customerService);
    }
}
