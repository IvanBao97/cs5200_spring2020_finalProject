package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
