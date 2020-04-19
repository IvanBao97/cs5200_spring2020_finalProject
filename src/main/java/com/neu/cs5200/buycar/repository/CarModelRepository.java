package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.CarModel;
import org.springframework.data.repository.CrudRepository;

public interface CarModelRepository extends CrudRepository<CarModel,Integer> {
}
