package com.smalldogg.springcoreinflearn.singleton;

public class SingletonService {

  public static final SingletonService instance = new SingletonService();

  public static SingletonService getInstance() {
    return instance;
  }

  private SingletonService() {

  }

  public void login() {
    System.out.println("싱글톤 객체 로직 호출");
  }
}
