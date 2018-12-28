package org.com.allen.enhance.basic.desginpattern.Strategy;

/**
 * 定义一组算法，将每个算法都封装起来，并且使它们之间可以交互。
 *
 * 策略模式和代理模式的差别在于： 1.封装的角色和被封装的策略类不是实现同一个接口
 *
 * 注意：如果一个策略的实现超过四个，建议使用混合模式。用于解决策略的膨胀和对外的暴露。否则不好维护。
 */
public class Client {

  public static void main(String[] args) {
    Context context = null;
    context = new Context(new BackDoor());
    context.operator();

    context = new Context(new GreenLight());
    context.operator();

    context = new Context(new BlockEnemy());
    context.operator();
  }
}
