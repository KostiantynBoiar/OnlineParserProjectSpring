package com.scrapper.usermicroservice.Service;

import com.scrapper.usermicroservice.Model.UserModel;
import com.scrapper.usermicroservice.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> userInfo = repository.findByName(username);
        return userInfo.map(UserDetailsService::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}