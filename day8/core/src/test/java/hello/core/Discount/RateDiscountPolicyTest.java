package hello.core.Discount;

import hello.core.customer.Customer;
import hello.core.customer.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("일반 회원")
    void BASIC_discount(){
        //given
        Customer customer = new Customer(1L, "basic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(customer, 10000);

        //then
        Assertions.assertEquals(0, discount);
    }

    @Test
    @DisplayName("VIP 회원")
    void VIP_discount(){
        //given
        Customer customer = new Customer(2L, "vip", Grade.VIP);

        //when
        int discount = discountPolicy.discount(customer, 10000);

        //then
        Assertions.assertEquals(10000 * 0.05, discount);
    }

    @Test
    @DisplayName("VVIP 회원")
    void VVIP_discount(){
        //given
        Customer customer = new Customer(3L, "vvip", Grade.VVIP);

        //when
        int discount = discountPolicy.discount(customer, 10000);

        //then
        Assertions.assertEquals(10000 * 0.1, discount);
    }
}