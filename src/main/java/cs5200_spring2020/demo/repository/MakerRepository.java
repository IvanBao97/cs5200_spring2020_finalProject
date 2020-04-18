package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Maker;
import org.springframework.data.repository.CrudRepository;

public interface MakerRepository extends CrudRepository<Maker,Integer> {
}
