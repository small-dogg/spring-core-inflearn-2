package com.smalldogg.springcoreinflearn.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototype2Test {

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
  void singletonClientUsePrototype() {
    AnnotationConfigApplicationContext ac =
        new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
    ClientBean bean1 = ac.getBean(ClientBean.class);
    int logic1 = bean1.logic();
    assertThat(logic1).isEqualTo(1);

    ClientBean bean2 = ac.getBean(ClientBean.class);
    int logic2 = bean2.logic();
    assertThat(logic2).isEqualTo(1);


  }

  @Scope("singleton")
  static class ClientBean {

    @Autowired
    private Provider<PrototypeBean> prototypeBeanProvider;//JSR-330 Provider
//    private ObjectProvider<PrototypeBean> prototypeBeanProvider;
//    private ObjectFactory<PrototypeBean> prototypeBeanProvider;

    public int logic() {
      //Depedency Lookup(DL)
      PrototypeBean object = prototypeBeanProvider.get();
//      PrototypeBean object = prototypeBeanProvider.getObject();
      object.addCount();
      int count = object.getCount();
      return count;
    }
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

}
