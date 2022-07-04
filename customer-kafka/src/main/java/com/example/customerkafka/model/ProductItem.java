package com.example.customerkafka.model;

import lombok.Data;





@Data
public class ProductItem {
    private Long id;
    private long productID;
    private double quantity;
    private double price;
    private Bill bill;
    private Product product;
    private String productName;
}
