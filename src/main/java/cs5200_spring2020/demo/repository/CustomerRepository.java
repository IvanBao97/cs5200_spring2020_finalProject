package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
