package com.allen.springframework.service;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.allen.springframework.BaseSpringJunitTest;
import com.allen.springframework.model.Stock;
import com.allen.springframework.service.impl.Portfolio;

public class PortfolioTester extends BaseSpringJunitTest {

    private Portfolio portfolio;

    private StockService stockService;

    @Before
    public void setUp() {
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketValue() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);
        stocks.add(googleStock);
        stocks.add(microsoftStock);

        // add stocks to the portfolio
        portfolio.setStocks(stocks);

        // mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
        double marketValue = portfolio.getMarketValue();
        System.out.println(marketValue);
    }

}
