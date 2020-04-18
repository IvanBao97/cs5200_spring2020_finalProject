package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    @Query("select customer from Customer customer")
    public List<Customer> findAllCustomers();

    @Query("select customer from Customer customer where customer.id=:cid")
    public Customer findCustomerById(@Param("cid") Integer customerId);

    @Query("delete from Customer customer")
    public void deleteAllCustomers();

    @Query("delete from Customer customer where customer.id=:cid")
    public void deleteCustomerById(@Param("cid") Integer customerId);
}
