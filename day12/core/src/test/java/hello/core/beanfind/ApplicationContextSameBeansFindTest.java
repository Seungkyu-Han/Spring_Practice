package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.customer.CustomerRepository;
import hello.core.customer.MemoryCustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeansFindTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(CustomerRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName(){
        CustomerRepository customerRepository = ac.getBean("customerRepository1", CustomerRepository.class);
        Assertions.assertInstanceOf(CustomerRepository.class, customerRepository);
    }

    @Test
    @DisplayName("특정 타입을 무도 조화하기")
    void findAllBeanByType(){
        Map<String, CustomerRepository> beansOfType = ac.getBeansOfType(CustomerRepository.class);
        for(String key: beansOfType.keySet()){
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public CustomerRepository customerRepository1() {
            return new MemoryCustomerRepository();
        }

        @Bean
        public CustomerRepository customerRepository2() {
            return new MemoryCustomerRepository();
        }
    }
}
