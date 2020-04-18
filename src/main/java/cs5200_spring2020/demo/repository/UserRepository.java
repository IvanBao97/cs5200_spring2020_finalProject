package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select user from User user")
    public List<User> findAllUser();


}
