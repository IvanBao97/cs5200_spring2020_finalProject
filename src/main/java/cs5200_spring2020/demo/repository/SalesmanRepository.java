package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.Salesman;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SalesmanRepository extends CrudRepository<Salesman,Integer> {
    @Query("select salesman from Salesman salesman")
    public List<Salesman> findAllSalesmen();

    @Query("select salesman from Salesman salesman where salesman.id=:sid")
    public Salesman findSalesmanById(@Param("sid") Integer salesmanId);

    @Query("select salesman from Salesman salesman where salesman.username=:username")
    public List<Salesman> findSalesmanByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("delete from Salesman salesman")
    public void deleteAllSalesmen();

    @Transactional
    @Modifying
    @Query("delete from Salesman salesman where salesman.id=:sid")
    public void deleteSalesmanById(@Param("sid") Integer salesmanId);
}
