package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Assertions.assertInstanceOf(CustomerService.class, customerService);
    }
}
