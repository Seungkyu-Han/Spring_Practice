package hello.core.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    CustomerService customerService = new CustomerServiceImpl();

    @Test
    void join(){
        //given
        Customer customer = new Customer(1L, "Seungkyu", Grade.VIP);

        //when
        customerService.join(customer);
        Customer findCustomer = customerService.findCustomer(1L);

        //then
        Assertions.assertEquals(customer, findCustomer);
    }
}
