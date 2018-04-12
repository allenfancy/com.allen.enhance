package com.allen.springframework.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.allen.springframework.service.impl.MathApplication;


@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    private MathApplication mathApplication = new MathApplication();

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(10.00, 20.00)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
    }

    @Test
    public void testSub() {
        when(calculatorService.subtract(10.00, 20.00)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.subtract(10.0, 20.0), 30.0, 0);
    }

    @Test
    public void testMultipy() {
        when(calculatorService.multipy(10.00, 20.00)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.multipy(10.0, 20.0), 30.0, 0);
    }

    @Test
    public void testDiv() {
        when(calculatorService.divide(10.00, 20.00)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.divide(10.0, 20.0), 30.0, 0);
    }
}
