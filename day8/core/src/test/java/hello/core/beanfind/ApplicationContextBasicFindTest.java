package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        CustomerService customerService = ac.getBean("customerService", CustomerService.class);
        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        CustomerService customerService = ac.getBean(CustomerService.class);

        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        CustomerServiceImpl customerService = ac.getBean("customerService", CustomerServiceImpl.class);
        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", CustomerService.class));
    }
}
