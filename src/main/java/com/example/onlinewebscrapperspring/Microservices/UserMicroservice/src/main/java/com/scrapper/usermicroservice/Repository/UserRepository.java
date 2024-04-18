package com.scrapper.usermicroservice.Repository;

import com.scrapper.usermicroservice.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    void deleteById(Long id);
    UserModel findByUsername(String username);
    Optional<UserModel> findById(Long id);
    void deleteByEmail(String email);
}
