package com.example.customerkafka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long billID;
  private String nameCustomer;
  private double montant;

}
