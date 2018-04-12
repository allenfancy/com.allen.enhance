package com.allen.springframework.service.impl;

import com.allen.springframework.service.CalculatorService;

public class MathApplication {

    private CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public CalculatorService getCalculatorService() {
        return calculatorService;
    }

    public double add(double input1, double input2) {
        return calculatorService.add(input1, input2);
    }

    public double subtract(double input1, double input2) {
        return calculatorService.subtract(input1, input2);
    }

    public double multipy(double input1, double intpu2) {
        return calculatorService.multipy(input1, intpu2);
    }

    public double divide(double input1, double input2) {
        return calculatorService.divide(input1, input2);
    }
}
