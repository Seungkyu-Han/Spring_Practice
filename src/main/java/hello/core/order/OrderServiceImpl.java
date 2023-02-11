package hello.core.order;

import hello.core.Discount.DiscountPolicy;
import hello.core.customer.Customer;
import hello.core.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final CustomerRepository customerRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(CustomerRepository customerRepository, DiscountPolicy discountPolicy) {
        this.customerRepository = customerRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Customer customer = customerRepository.findById(id);
        int discountPrice = discountPolicy.discount(customer, itemPrice);

        return new Order(id, itemName, itemPrice, discountPrice);
    }

    public CustomerRepository customerRepository(){
        return customerRepository;
    }
}
