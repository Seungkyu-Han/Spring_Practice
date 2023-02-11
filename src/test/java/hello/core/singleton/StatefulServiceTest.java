package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

    @Test
    void statefulServiceSingleton(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = applicationContext.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = applicationContext.getBean("statefulService", StatefulService.class);

        statefulService1.order("A", 1000);
        statefulService2.order("B", 2000);

        Assertions.assertNotEquals(1000, statefulService1.getPay());
    }
}
