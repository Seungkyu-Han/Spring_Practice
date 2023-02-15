package hello.core.Discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.customer.Customer;
import hello.core.customer.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int VIPDiscountPercent = 5; // 할인되는 비율
    private int VVIPDiscountPercent = 10; //할인되는 비율

    @Override
    public int discount(Customer customer, int price) {
        if(customer.getGrade() == Grade.VIP){
            return price * VIPDiscountPercent / 100;
        }
        else if (customer.getGrade() == Grade.VVIP){
            return price * VVIPDiscountPercent / 100;
        }
        else{
            return 0;
        }
    }
}
