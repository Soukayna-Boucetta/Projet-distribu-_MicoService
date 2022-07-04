package com.example.producerkafka.feign;


import com.example.producerkafka.model.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BILLING-SERVICE")
public interface BillRestClient {
    @GetMapping(path = "/fullBill/{id}")
    public Bill getCustomerById(@PathVariable(name = "id") Long id);

}
