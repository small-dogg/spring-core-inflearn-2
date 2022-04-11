package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.discount.DiscountPolicy;
import com.smalldogg.springcoreinflearn.discount.FixDiscountPolicy;
import com.smalldogg.springcoreinflearn.discount.RateDiscountPolicy;
import com.smalldogg.springcoreinflearn.member.MemberRepository;
import com.smalldogg.springcoreinflearn.member.MemberService;
import com.smalldogg.springcoreinflearn.member.MemberServiceImpl;
import com.smalldogg.springcoreinflearn.member.MemoryMemberRepository;
import com.smalldogg.springcoreinflearn.order.OrderService;
import com.smalldogg.springcoreinflearn.order.OrderServiceImpl;

public class AppConfig {

  //생성자 주입
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  private MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  public DiscountPolicy discountPolicy(){
    return new RateDiscountPolicy();
  }

}
