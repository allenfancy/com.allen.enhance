package org.com.allen.enhance.basic.desginpattern.interpreter.demo;

import java.util.Map;
import java.util.Stack;

/**
 * @author allen.wu
 * @since 2018-09-14 01:34
 */
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> expressionStack = new Stack<>();
        char[] charArray = expStr.toCharArray();
        Expression left;
        Expression right;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = expressionStack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    expressionStack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = expressionStack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    expressionStack.push(new SubExpression(left, right));
                    break;
                default:
                    expressionStack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        // 结果抛出来
        this.expression = expressionStack.pop();
    }

    public int run(Map<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
