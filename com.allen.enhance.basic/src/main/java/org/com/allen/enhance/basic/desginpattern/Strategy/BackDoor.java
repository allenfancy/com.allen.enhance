package org.com.allen.enhance.basic.desginpattern.Strategy;

public class BackDoor implements Istrategy {
  @Override
  public void operator() {
    System.out.println("找吴大人帮忙");
  }
}
