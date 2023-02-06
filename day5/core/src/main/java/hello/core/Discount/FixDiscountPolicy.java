package hello.core.Discount;

import hello.core.customer.Customer;
import hello.core.customer.Grade;

public class FixDiscountPolicy implements DiscountPolicy{

    private int VIPDiscountFixAmount = 500; // 할인되는 금액
    private int VVIPDiscountFixAmount = 1000; //할인되는 금액

    @Override
    public int discount(Customer customer, int price){
        if(customer.getGrade() == Grade.VVIP){
            return VVIPDiscountFixAmount;
        }
        else if(customer.getGrade() == Grade.VIP){
            return VIPDiscountFixAmount;
        }
        else{
            return 0;
        }
    }
}
