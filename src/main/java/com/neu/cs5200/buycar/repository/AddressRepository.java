package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Integer> {
    @Query("select address from Address address")
    public List<Address> findAllAddresses();

    @Query("select address from Address address where address.id = :id")
    public Address findAddressById(@Param("id") int id);

    @Query("select address from Address address where address.street = :street")
    public List<Address> findAllAddressesByStreet(@Param("street") String street);

    @Query("select address from Address address where address.city = :city")
    public List<Address> findAllAddressesByCity(@Param("city") String city);

    @Query("select address from Address address where address.state = :state")
    public List<Address> findAllAddressesByState(@Param("state") String state);

    @Query("select address from Address address where address.zipcode = :zipcode")
    public List<Address> findAllAddressesByZipcode(@Param("zipcode") String zipcode);

    @Transactional
    @Modifying
    @Query("delete from Address address")
    public void deleteAllAddresses();

    @Transactional
    @Modifying
    @Query("delete from Address address where address.id =:id")
    public void deleteAddressById(@Param("id") Integer AddressId);
}
