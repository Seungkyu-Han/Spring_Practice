package hello.core.Discount;

import hello.core.customer.Customer;

public interface DiscountPolicy {

    //return 이 할인 대상 금액
    int discount(Customer customer, int price);


}
