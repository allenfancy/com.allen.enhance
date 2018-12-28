package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

import java.util.Map;

/**
 * @author allen.wu
 * @since 2018-09-14 01:34
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
