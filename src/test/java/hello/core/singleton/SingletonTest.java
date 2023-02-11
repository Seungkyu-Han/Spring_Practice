package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.customer.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        CustomerService customerService1 = appConfig.customerService();
        CustomerService customerService2 = appConfig.customerService();

        System.out.println("CustomerService1 = " + customerService1);
        System.out.println("CustomerService2 = " + customerService2);

        Assertions.assertNotSame(customerService1, customerService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        Assertions.assertSame(singletonService1, singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService1 = applicationContext.getBean("customerService", CustomerService.class);
        CustomerService customerService2 = applicationContext.getBean("customerService", CustomerService.class);

        System.out.println("customerService1 = " + customerService1);
        System.out.println("customerService2 = " + customerService2);

        Assertions.assertSame(customerService1, customerService2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = applicationContext.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());

        AppConfig appConfig = new AppConfig();

        System.out.println("AppConfig = " + appConfig.getClass());

    }
}
