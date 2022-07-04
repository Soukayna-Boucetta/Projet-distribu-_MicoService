package com.example.producerkafka.web;

import com.example.producerkafka.entities.Facture;
import com.example.producerkafka.feign.BillRestClient;
import com.example.producerkafka.feign.CustomerRestClient;
import com.example.producerkafka.model.Bill;
import com.example.producerkafka.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.Random;
@RestController
public class FactureRestController {
    @Autowired
    private StreamBridge streamBrige;
    @GetMapping("/publish/{topic}")
    public Facture publish(@PathVariable String topic){
        Facture facture=new Facture(
                new Random().nextLong(),
                Math.random()>0.5?"soukayna":"Hamza",
                new Random().nextDouble()
        );
        streamBrige.send(topic,facture);
        return facture;

    }
}
