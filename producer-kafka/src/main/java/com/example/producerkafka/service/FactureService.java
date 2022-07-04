package com.example.producerkafka.service;

import com.example.producerkafka.entities.Facture;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Supplier;

@Service
public class FactureService {
    @Bean
    public Supplier<Facture> factureSupplier(){
        return ()-> new Facture(
                    new Random().nextLong(),
                    Math.random()>0.5?"soukayna":"Hamza",
                    new Random().nextDouble());

    }
}
