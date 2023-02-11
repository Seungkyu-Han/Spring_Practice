package hello.core.beanfind;

import hello.core.customer.CustomerRepository;
import hello.core.customer.MemoryCustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    @Configuration
    static class SameBeanConfig{

        @Bean
        public CustomerRepository customerRepository1(){
            return new MemoryCustomerRepository();
        }

        @Bean
        public CustomerRepository customerRepository2(){
            return new MemoryCustomerRepository();
        }
    }

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> applicationContext.getBean(CustomerRepository.class));
    }

    @Test
    @DisplayName("그렇기 때문에 같은 타입이 둘 이상 있으면, 빈 이름을 지정해야 한다.")
    void findBeanByName(){
        CustomerRepository customerRepository = applicationContext.getBean("customerRepository1", CustomerRepository.class);

        Assertions.assertInstanceOf(CustomerRepository.class, customerRepository);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, CustomerRepository> beansOfType = applicationContext.getBeansOfType(CustomerRepository.class);
        for(String key : beansOfType.keySet()){
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }

        System.out.println("beansOfType = " + beansOfType);
    }
}
