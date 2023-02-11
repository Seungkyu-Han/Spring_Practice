package hello.core.xml;

import hello.core.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");

        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        Assertions.assertInstanceOf(CustomerService.class, customerService);
    }
}
