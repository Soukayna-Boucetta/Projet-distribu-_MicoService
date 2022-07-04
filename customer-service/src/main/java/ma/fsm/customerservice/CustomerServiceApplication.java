package ma.fsm.customerservice;

import ma.fsm.customerservice.entities.Customer;
import ma.fsm.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return  args -> {
            customerRepository.save(new Customer(null,"mouad","mouad@gmail.com"));
            customerRepository.save(new Customer(null,"Yassir","Yassir@gmail.com"));
            customerRepository.save(new Customer(null,"samir","samir@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
                    });

        };
    }

}
