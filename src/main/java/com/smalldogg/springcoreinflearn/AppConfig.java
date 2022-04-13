package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.discount.DiscountPolicy;
import com.smalldogg.springcoreinflearn.discount.RateDiscountPolicy;
import com.smalldogg.springcoreinflearn.member.MemberRepository;
import com.smalldogg.springcoreinflearn.member.MemberService;
import com.smalldogg.springcoreinflearn.member.MemberServiceImpl;
import com.smalldogg.springcoreinflearn.member.MemoryMemberRepository;
import com.smalldogg.springcoreinflearn.order.OrderService;
import com.smalldogg.springcoreinflearn.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


  @Bean
  public MemberService memberService() {
    //soutm shortcut
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
//    return null;
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new RateDiscountPolicy();
  }

}
