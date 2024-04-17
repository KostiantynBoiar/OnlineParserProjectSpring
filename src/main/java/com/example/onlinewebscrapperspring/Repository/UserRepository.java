package com.example.onlinewebscrapperspring.Repository;

import com.example.onlinewebscrapperspring.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    void deleteById(Long id);
    Optional<UserModel> findModelById(Long id);
}
