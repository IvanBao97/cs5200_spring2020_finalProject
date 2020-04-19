package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.User;
import cs5200_spring2020.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    //Create User
    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    //Update User
    @PutMapping("/api/user/{userId}")
    public User updateUser(
            @PathVariable("userId") int id,
            @RequestBody User newUser) {
        User user = userRepository.findUserById(id);
        if(newUser.getName() != null){
            user.setUsername(newUser.getUsername());
        }
        if(newUser.getPassword() != null){
            user.setPassword(newUser.getPassword());
        }
        if(newUser.getEmail() != null){
            user.setEmail(newUser.getEmail());
        }
        if(newUser.getName() != null){
            user.setName(newUser.getName());
        }
        if(newUser.getPhone() != null){
            user.setPhone(newUser.getPhone());
        }
        if(newUser.getEnable() != null){
            user.setEnable(newUser.getEnable());
        }
        if(newUser.getRole() != null){
            user.setRole(newUser.getRole());
        }

        return userRepository.save(user);
    }

    //FindAllUsers
    @GetMapping("/api/user")
    public List<User> findAllUsers(){
        return userRepository.findAllUsers();
    }

    //FindUserById
    @GetMapping("/api/user/id/{uid}")
    public User findUserById(@PathVariable("uid") Integer uid){
        return userRepository.findUserById(uid);
    }

    //FindUserByUsername
    @GetMapping("/api/user/username/{username}")
    public List<User> findUserByUsername(@PathVariable(name="username") String username) {
        if(username != null) {
            return userRepository.findUserByUsername(username);
        }
        return userRepository.findAllUsers();
    }

    //DeleteAllUsers
    @DeleteMapping("/api/user")
    public void deleteAllUsers(){
        userRepository.deleteAllUsers();
    }

    //DeleteUserById
    @DeleteMapping("/api/user/{uid}")
    public void deleteUserById(@PathVariable("uid") Integer uid){
        userRepository.deleteUserById(uid);
    }


}
