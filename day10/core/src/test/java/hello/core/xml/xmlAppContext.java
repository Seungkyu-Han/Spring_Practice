package hello.core.xml;

import hello.core.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class xmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);

        Assertions.assertInstanceOf(CustomerService.class, customerService);
    }
}
