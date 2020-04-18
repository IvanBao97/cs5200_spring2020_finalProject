package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Salesman;
import org.springframework.data.repository.CrudRepository;

public interface SalesmanRepository extends CrudRepository<Salesman,Integer> {
}
