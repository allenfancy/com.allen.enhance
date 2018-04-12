package com.allen.springframework.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {

    private String stockID;
    private String name;
    private int qunatity;
    
}
