package hello.core.order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Discount.FixDiscountPolicy;
import hello.core.customer.Customer;
import hello.core.customer.CustomerRepository;
import hello.core.customer.MemoryCustomerRepository;

public class OrderServiceImpl implements OrderService{

    private final CustomerRepository customerRepository = new MemoryCustomerRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Customer customer = customerRepository.findById(id);
        int discountPrice = discountPolicy.discount(customer, itemPrice);

        return new Order(id, itemName, itemPrice, discountPrice);
    }
}
