package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.CarModel;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<CarModel,Integer> {
}
