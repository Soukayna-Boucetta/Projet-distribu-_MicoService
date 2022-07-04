package com.example.customerkafka.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private  String name;
    private double price;
    private double quality;
}
