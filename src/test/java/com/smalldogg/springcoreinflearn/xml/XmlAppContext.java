package com.smalldogg.springcoreinflearn.xml;

import com.smalldogg.springcoreinflearn.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

  @Test
  void xmlAppContext() {
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
