package com.scrapper.usermicroservice.Controller;

import com.scrapper.usermicroservice.Model.UserModel;
import com.scrapper.usermicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "loginUser";
    }


    @GetMapping("/admin/login")
    public String adminLogin() {
        return "adminLogin";
    }

    @GetMapping("/user/get")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register/user")
    public UserModel createUser(@RequestBody UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userService.createUser(userModel);
    }

    @PutMapping("/user/update")
    public UserModel updateUser(@RequestBody UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userService.updateUser(userModel);
    }

    @DeleteMapping("/user/delete/id")
    public void deleteById(Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/user/delete/email")
    public void deleteByEmail(String email){
        userService.deleteByEmail(email);
    }



}
