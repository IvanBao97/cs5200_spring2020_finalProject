package cs5200_spring2020.demo.repository;

import cs5200_spring2020.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select user from User user")
    public List<User> findAllUsers();

    @Query("select user from User user where user.id=:uid")
    public User findUserById(@Param("uid") Integer userId);

    @Query("delete from User user")
    public void deleteAllUsers();

    @Query("delete from User user where user.id=:uid")
    public void deleteUserById(@Param("uid") Integer userId);
}
