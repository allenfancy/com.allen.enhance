package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

import java.util.Map;

/**
 * @author allen.wu
 * @since 2018-09-14 01:28
 */
public abstract class Expression {

    protected abstract int interpreter(Map<String, Integer> var);
}
