package com.smalldogg.springcoreinflearn.scan;

import static org.assertj.core.api.Assertions.assertThat;

import com.smalldogg.springcoreinflearn.AutoAppConfig;
import com.smalldogg.springcoreinflearn.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        AutoAppConfig.class);

    MemberService bean = ac.getBean(MemberService.class);
    assertThat(bean).isInstanceOf(MemberService.class);
  }
}
