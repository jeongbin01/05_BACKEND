package com.shop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.entity.SiteUser;
import com.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();

        user.setUsemame(username);
        user.setEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));

        this.userRepository.save(user);
        return user;

    }
}
