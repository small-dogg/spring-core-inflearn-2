package com.smalldogg.springcoreinflearn.discount;

import com.smalldogg.springcoreinflearn.annotation.MainDiscountPolicy;
import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

  private int discountPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if(member.getGrade() == Grade.VIP){
      return price * discountPercent / 100;
    }else{
      return 0;
    }
  }
}
