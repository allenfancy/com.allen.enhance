package org.com.allen.enhance.basic.desginpattern.Strategy;

public enum Calculator {

  ADD("+") {
    @Override
    protected int exec(int a, int b) {
      return a + b;
    }
  },
  SUB("-") {
    @Override
    protected int exec(int a, int b) {
      return a - b;
    }
  };
  String value = "";

  private Calculator(String _value) {
    this.value = _value;
  }

  protected abstract int exec(int a, int b);
}

