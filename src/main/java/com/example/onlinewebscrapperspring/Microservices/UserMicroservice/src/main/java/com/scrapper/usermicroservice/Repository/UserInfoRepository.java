package com.scrapper.usermicroservice.Repository;
import com.scrapper.usermicroservice.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByName(String username);

}
