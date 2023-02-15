package hello.core.order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.annotation.MainDiscountPolicy;
import hello.core.customer.Customer;
import hello.core.customer.CustomerRepository;
import hello.core.customer.MemoryCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderServiceImpl implements OrderService{

    private final CustomerRepository customerRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository, @MainDiscountPolicy DiscountPolicy rateDiscountPolicy){
        this.customerRepository = customerRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Customer customer = customerRepository.findById(id);
        int discountPrice = discountPolicy.discount(customer, itemPrice);

        return new Order(id, itemName, itemPrice, discountPrice);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
