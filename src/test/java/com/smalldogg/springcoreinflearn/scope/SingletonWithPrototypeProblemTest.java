package com.smalldogg.springcoreinflearn.scope;

import static org.assertj.core.api.Assertions.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

//싱글톤 빈에서 프로토타입 빈을 주입받아 사용을 하면,
//싱글톤 빈의 특성상 생성시점에 한번만 주입을 받기 때문에,
// 생성시점에 프로토타입 빈을 한번만 주입받게 된다.
// 프로토타입의 특징인 스프링이 생성만 해주고
// 이후 관리를 안해주기 때문에, 매번 호출 시 새로운 인스턴스를 생성해주는 특징을
// 살리지 못하는 문제가 발생한다.
// 즉, 싱글톤 빈 내에서 프로토타입 빈을 주입받으면 프토토타입 빈을 호출하더라도, 같은 대상을 참조하는 문제가 생긴다.
public class SingletonWithPrototypeProblemTest {

  @Test
  void prototypeFind() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
    prototypeBean1.addCount();
    assertThat(prototypeBean1.getCount()).isEqualTo(1);

    PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
    prototypeBean2.addCount();
    assertThat(prototypeBean2.getCount()).isEqualTo(1);
  }

  @Test
  void singletonClinetUsePrototype() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
    ClientBean bean1 = ac.getBean(ClientBean.class);
    int logic1 = bean1.logic();
    assertThat(logic1).isEqualTo(1);

    ClientBean bean2 = ac.getBean(ClientBean.class);
    int logic2 = bean2.logic();
    assertThat(logic2).isEqualTo(2);


  }

  @Scope("prototype")
  static class PrototypeBean {
    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init" + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }

  @Scope("Singleton")
  static class ClientBean {
    private final PrototypeBean prototypeBean; //생성시점에 주입

    @Autowired
    public ClientBean(PrototypeBean prototypeBean) {
      this.prototypeBean = prototypeBean;
    }

    public int logic() {
      prototypeBean.addCount();
      int count = prototypeBean.getCount();
      return count;
    }
  }

}
