package com.example.onlinewebscrapperspring.Repository;

import com.example.onlinewebscrapperspring.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    void deleteById(Long id);
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findAllByLastName(String email, String lastName);
    void deleteByEmail(String email);
}
