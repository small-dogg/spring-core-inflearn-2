package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import com.smalldogg.springcoreinflearn.member.MemberService;
import com.smalldogg.springcoreinflearn.order.Order;
import com.smalldogg.springcoreinflearn.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "orderA", 10000);

    System.out.println("order = " + order);
  }

}
