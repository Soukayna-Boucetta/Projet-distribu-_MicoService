package com.example.customerkafka.service;

import com.example.customerkafka.entities.Facture;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.function.Consumer;

@Service
public class FactureService {
    @Bean
    public Consumer<Facture> factureCustomer(){
        return (input)->{
            System.out.println("les information de la facture sont: ");

            System.out.println(input.toString());
            Facture facture=new Facture(input.getBillID(),input.getNameCustomer(),input.getMontant());
        };
    }
}

