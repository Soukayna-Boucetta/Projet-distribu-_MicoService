package ma.fsm.customerservice.web;

import ma.fsm.customerservice.entities.Customer;
import ma.fsm.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@CrossOrigin("*")
public class CustomerRestControler{
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping(path="/customers")
    public List<Customer> list(){
        return customerRepository.findAll();

    }
    @GetMapping(path = "/customers/{id}")
    public Customer getOne(@PathVariable Long id){
        return customerRepository.findById(id).get();

    }
    @PostMapping(path = "/customers")
    public Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);

    }
    @PutMapping(path = "/customers/{id}")
    public Customer update(@PathVariable Long id,@RequestBody Customer customer){
        customer.setId(id);
        return customerRepository.save(customer);

    }
    @DeleteMapping(path = "/customers/{id}")
    public void delete(@PathVariable Long id){
        customerRepository.deleteById(id);

    }
}