package com.neu.cs5200.buycar.repository;

import com.neu.cs5200.buycar.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select user from User user")
    public List<User> findAllUsers();

    @Query("select user from User user where user.id=:uid")
    public User findUserById(@Param("uid") Integer userId);

    @Query("select user from User user where user.username=:username")
    public List<User> findUserByUsername(@Param("username") String username);

    @Query("SELECT user from User user WHERE user.username=:username AND user.password=:password")
    public List<User> findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password
    );

    @Transactional
    @Modifying
    @Query("delete from User user")
    public void deleteAllUsers();

    @Transactional
    @Modifying
    @Query("delete from User user where user.id=:uid")
    public void deleteUserById(@Param("uid") Integer userId);


}
