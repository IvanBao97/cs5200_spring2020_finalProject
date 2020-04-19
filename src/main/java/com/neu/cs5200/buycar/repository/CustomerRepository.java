package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    @Query("select customer from Customer customer")
    public List<Customer> findAllCustomers();

    @Query("select customer from Customer customer where customer.id=:cid")
    public Customer findCustomerById(@Param("cid") Integer customerId);

    @Query("select customer from Customer customer where customer.username=:username")
    public List<Customer> findCustomerByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("delete from Customer customer")
    public void deleteAllCustomers();

    @Transactional
    @Modifying
    @Query("delete from Customer customer where customer.id=:cid")
    public void deleteCustomerById(@Param("cid") Integer customerId);
}
