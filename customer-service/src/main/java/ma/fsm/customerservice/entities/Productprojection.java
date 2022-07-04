package ma.fsm.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "C1",types = Customer.class)
public interface Productprojection {
   public double getName();


}
