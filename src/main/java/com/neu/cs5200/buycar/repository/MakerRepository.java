package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.Maker;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MakerRepository extends CrudRepository<Maker,Integer> {
    @Query("select maker from Maker maker")
    public List<Maker> findAllMakers();

    @Query("select maker from Maker maker where maker.id = :id")
    public Maker findMakerById(@Param("id") int id);

    @Query("select maker from Maker maker where maker.name = :name")
    public List<Maker> findAllMakersByName(@Param("name") String name);

    @Query("select maker from Maker maker where maker.country = :country")
    public List<Maker> findAllMakersByCountry(@Param("country") String country);

    @Query("select maker from Maker maker where maker.name = :name and maker.country = :country")
    public Maker findMakerByNameAndCountry(@Param("name") String name, @Param("country") String country);

    @Transactional
    @Modifying
    @Query("delete from Maker maker where maker.id =:id")
    public void deleteMakerById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("delete from Maker maker")
    public void deleteAllMaker();
}
