package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

import java.util.Map;

/**
 * @author allen.wu
 * @since 2018-09-14 01:29
 *
 * 变量解析器
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    protected int interpreter(Map<String, Integer> var) {
        return var.get(this.key);
    }
}
