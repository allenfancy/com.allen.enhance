package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

/**
 * @author allen.wu
 * @since 2018-09-14 01:31
 * 抽象运算符解析器
 */
public abstract class SymbolExpression extends Expression{

    protected Expression left;

    protected Expression right;

    public SymbolExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }

}
