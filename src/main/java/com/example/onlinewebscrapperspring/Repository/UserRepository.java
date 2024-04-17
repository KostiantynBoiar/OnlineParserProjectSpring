package com.example.onlinewebscrapperspring.Repository;

import com.example.onlinewebscrapperspring.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    void deleteById(Long id);
    Optional<UserModel> findById(Long id);
    void deleteByEmail(String email);
}
