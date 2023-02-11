package hello.core;

import hello.core.customer.CustomerRepository;
import hello.core.customer.CustomerService;
import hello.core.customer.MemoryCustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryCustomerRepository")
//    CustomerRepository customerRepository(){
//        return new MemoryCustomerRepository();
//    }
}
