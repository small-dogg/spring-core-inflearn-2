package com.smalldogg.springcoreinflearn.order;

import static org.junit.jupiter.api.Assertions.*;

import com.smalldogg.springcoreinflearn.discount.FixDiscountPolicy;
import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import com.smalldogg.springcoreinflearn.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

  @Test
  void createOrder() {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

    OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    Order order = orderService.createOrder(1L, "itemA", 10000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


  }
}