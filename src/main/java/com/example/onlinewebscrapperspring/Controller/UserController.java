package com.example.onlinewebscrapperspring.Controller;

import com.example.onlinewebscrapperspring.Model.UserModel;
import com.example.onlinewebscrapperspring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/get")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/post")
    public void postUser(@RequestBody UserModel userModel) {
        userService.createUser(userModel);
    }

    @PutMapping("/users/put")
    public void putUser(@RequestBody UserModel userModel) {
        userService.updateUser(userModel);
    }

    @DeleteMapping("/users/delete/id")
    public void deleteById(Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/users/delete/email")
    public void deleteByEmail(String email){
        userService.deleteByEmail(email);
    }



}
