package com.smalldogg.springcoreinflearn.singleton;

public class StatefulService {

//  private int price;//상태를 유지하는  필드

  public int order(String name, int price) {
    System.out.println("name = " + name + " price = " + price);
    //지역변수를 통해, price를 stateless하게 만듦.
    return price;
  }

//  public int getPrice() {
//    return price;
//  }
}
