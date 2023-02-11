package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때마다 객체를 생성

        CustomerService customerService1 = appConfig.customerService();

        CustomerService customerService2 = appConfig.customerService();

        //참조값을 비교
        System.out.println("customerService1 = " + customerService1);
        System.out.println("customerService2 = " + customerService2);

        Assertions.assertNotSame(customerService1, customerService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertSame(singletonService1, singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회 : 호출할 때마다 객체를 생성

        CustomerService customerService1 = annotationConfigApplicationContext.getBean("customerService", CustomerService.class);

        CustomerService customerService2 = annotationConfigApplicationContext.getBean("customerService", CustomerService.class);

        //참조값을 비교
        System.out.println("customerService1 = " + customerService1);
        System.out.println("customerService2 = " + customerService2);

        Assertions.assertSame(customerService1, customerService2);
    }
}
