package ma.fsm.customerservice.repository;

import ma.fsm.customerservice.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @RestResource(path="/byName")
    public Page<Customer> findByNameContains(@Param("kw") String name, Pageable pageable);



}

