package com.example.producerkafka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture {
  private Long billID;
  private String nameCustomer;
  private double montant;

}
