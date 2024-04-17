package com.example.onlinewebscrapperspring.Controller;

import com.example.onlinewebscrapperspring.Model.UserModel;
import com.example.onlinewebscrapperspring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/all")
    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepository.findAll();
    }

    @PostMapping("/users/post")
    public void postUser(@ModelAttribute("userModel") UserModel userModel) {
        userRepository.save(userModel);
    }

    @PutMapping("/users/put")
    public void putUser(@ModelAttribute("userModel") UserModel userModel) {
        userRepository.save(userModel);
    }

    @DeleteMapping("/users/delete/id")
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @DeleteMapping("/users/delete/email")
    public void deleteByEmail(String email){
        userRepository.deleteByEmail(email);
    }



}
