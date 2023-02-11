package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.customer.CustomerService;
import hello.core.customer.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름, 타입으로 조회")
    void findBeanByName(){
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);

        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("타입으로만 조회")
    void findBeanByType(){
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        CustomerServiceImpl customerService = applicationContext.getBean("customerService", CustomerServiceImpl.class);

        Assertions.assertInstanceOf(CustomerServiceImpl.class, customerService);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameFail(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> applicationContext.getBean("abcd", CustomerServiceImpl.class));
    }
}