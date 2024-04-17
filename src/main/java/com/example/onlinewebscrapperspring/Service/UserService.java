package com.example.onlinewebscrapperspring.Service;

import com.example.onlinewebscrapperspring.Model.UserModel;
import com.example.onlinewebscrapperspring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findModelById(id);
    }
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }
    public UserModel updateUser(UserModel userModel) {
        return userRepository.save(userModel);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
