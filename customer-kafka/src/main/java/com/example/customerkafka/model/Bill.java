package com.example.customerkafka.model;

import lombok.Data;

import java.util.Collection;
import java.util.Date;
@Data
public class Bill {
    private Long id;
    private Date billingDate;
    private Collection<ProductItem> productItems;
    private Long customerID;
    private Customer customer;

}
