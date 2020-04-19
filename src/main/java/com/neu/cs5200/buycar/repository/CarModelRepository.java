package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.CarModel;
import com.neu.cs5200.buycar.domain.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CarModelRepository extends CrudRepository<CarModel,Integer> {
    @Query("select carModel from CarModel carModel")
    public List<CarModel> findAllCarModels();

    @Query("select carmodel from CarModel carmodel where carmodel.id = :id")
    public CarModel findCarModelById(@Param("id") int id);

    @Query("select carmodel from CarModel carmodel where carmodel.name = :name")
    public List<CarModel> findAllCarModelsByName(@Param("name") String name);

    @Query("select carmodel from CarModel carmodel where carmodel.year = :year")
    public List<CarModel> findAllCarModelsByYear(@Param("year") int year);

    @Query("select carmodel from CarModel carmodel where carmodel.color = :color")
    public List<CarModel> findAllCarModelsByColor(@Param("color") String color);

    @Query("select carmodel from CarModel carmodel where carmodel.vin = :vin")
    public CarModel findCarModelByVin(@Param("vin") String vin);

    @Query("select carmodel from CarModel carmodel where carmodel.type = :type")
    public List<CarModel> findAllCarModelsByType(@Param("type") Customer.CarType type);

    @Transactional
    @Modifying
    @Query("delete from CarModel carmodel where carmodel.id =:id")
    public void deleteCarModelById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("delete from CarModel carmodel")
    public void deleteAllCarModel();
}
