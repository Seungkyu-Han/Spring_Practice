package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class ComponentFilterAppConfigTest {

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = TmpIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = TmpExcludeComponent.class)
    )
    static class ComponentFilterAppConfig{
        @Bean
        public MyBeanA myBeanA(){
            return new MyBeanA();
        }
    }

    @Test
    void filterScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        MyBeanA myBeanA = applicationContext.getBean("myBeanA", MyBeanA.class);
        Assertions.assertNotNull(myBeanA);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("myBeanB", MyBeanB.class));
    }
}
