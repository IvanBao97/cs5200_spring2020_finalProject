package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.User;
import cs5200_spring2020.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAllCourses(){
        return userRepository.findAllUser();
    }


}
