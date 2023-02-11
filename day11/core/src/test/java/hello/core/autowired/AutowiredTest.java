package hello.core.autowired;

import hello.core.customer.Customer;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Customer noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Customer noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Customer> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
