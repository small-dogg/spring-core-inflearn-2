package com.smalldogg.springcoreinflearn.scan.allbean;

import static org.assertj.core.api.Assertions.*;

import com.smalldogg.springcoreinflearn.AutoAppConfig;
import com.smalldogg.springcoreinflearn.discount.DiscountPolicy;
import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {

  //동적으로 빈을 선택해야할 때, 다형성 코드를 유지함과 동시에 동적으로 빈을 사용할 수 있다.
  @Test
  void findAllBean(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
    DiscountService discountService = ac.getBean(DiscountService.class);
    Member member = new Member(1L, "userA", Grade.VIP);
    int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
    assertThat(discountService).isInstanceOf(DiscountService.class);
    assertThat(discountPrice).isEqualTo(1000);

    int rateDiscountPolicy = discountService.discount(member, 20000, "rateDiscountPolicy");
    assertThat(rateDiscountPolicy).isEqualTo(2000);
  }

  static class DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policyList;

    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
      this.policyMap = policyMap;
      this.policyList = policyList;

      System.out.println("policyMap = " + policyMap);
      System.out.println("policyList = " + policyList);
    }

    public int discount(Member member, int price, String discountCode) {
      DiscountPolicy discountPolicy = policyMap.get(discountCode);
      return discountPolicy.discount(member,price);
    }
  }


}
