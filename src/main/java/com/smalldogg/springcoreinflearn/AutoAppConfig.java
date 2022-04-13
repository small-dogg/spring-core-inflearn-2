package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.discount.DiscountPolicy;
import com.smalldogg.springcoreinflearn.member.MemberRepository;
import com.smalldogg.springcoreinflearn.member.MemberService;
import com.smalldogg.springcoreinflearn.member.MemoryMemberRepository;
import com.smalldogg.springcoreinflearn.order.OrderService;
import com.smalldogg.springcoreinflearn.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "com.smalldogg.springcoreinflearn",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//  @Bean(name="memoryMemberRepository")
//  MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//  }
}
