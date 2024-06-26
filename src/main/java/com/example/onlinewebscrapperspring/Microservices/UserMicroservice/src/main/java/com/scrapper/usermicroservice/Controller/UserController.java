package com.scrapper.usermicroservice.Controller;

import com.scrapper.usermicroservice.DTO.AuthRequest;
import com.scrapper.usermicroservice.Model.UserModel;
import com.scrapper.usermicroservice.Service.JwtService;
import com.scrapper.usermicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "adminLogin";
    }

    @GetMapping("/api/v1/users/get")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/v1/users/register")
    public UserModel createUser(@RequestBody UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userService.createUser(userModel);
    }

    @PutMapping("/api/v1/users/update")
    public UserModel updateUser(@RequestBody UserModel userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userService.updateUser(userModel);
    }

    @DeleteMapping("/api/v1/users/delete/id")
    public void deleteById(Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/api/v1/users/delete_by_email")
    public void deleteByEmail(String email){
        userService.deleteByEmail(email);
    }

    @PostMapping("/api/v1/users/auth")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        return jwtService.generateToken(authRequest.getUsername());
    }

}
