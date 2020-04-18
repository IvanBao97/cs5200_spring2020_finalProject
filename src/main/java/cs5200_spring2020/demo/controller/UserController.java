package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.User;
import cs5200_spring2020.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/create/alice")
    public User createAlice(){
        User admin = new User(
                "admin",
                "admin",
                "admin@husky.neu.edu",
                "admin",
                null,
                "11111111",
                User.Role.Admin
        );
        userRepository.save(admin);
        return admin;
    }

    @GetMapping("/user/{uid}/update/{name}")
    public User updateUserName(
            @PathVariable("uid") Integer userId,
            @PathVariable("name") String name
    ){
        User user = userRepository.findUserById(userId);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @GetMapping("/user")
    public List<User> findAllUsers(){
        return userRepository.findAllUsers();
    }

    @GetMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        return userRepository.findUserById(uid);
    }

    @GetMapping("/user/delete")
    public void deleteAllUsers(){
        userRepository.deleteAllUsers();
    }

    @GetMapping("/user/delete/{uid}")
    public void deleteUserById(@PathVariable("uid") Integer uid){
        userRepository.deleteUserById(uid);
    }


}
