package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import com.smalldogg.springcoreinflearn.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("Member = " + member.getName());
    System.out.println("findMember = " + findMember.getName());
  }
}
