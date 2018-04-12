package com.allen.springframework.service.impl;

import java.util.List;

import com.allen.springframework.model.Stock;
import com.allen.springframework.service.StockService;

public class Portfolio {

    private StockService stockService;

    private List<Stock> stocks;

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue() {
        double marketValue = 0.0;
        for (Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQunatity();
        }
        return marketValue;
    }
}
