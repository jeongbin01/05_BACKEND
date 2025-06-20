package com.shop.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.shop.entity.SiteUser;
import com.shop.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원 가입 메소드
    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();

        user.setUsername(username);  
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }
    
    // 회원 페이징 리스트 메소드
    public Page<SiteUser> getUserList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return userRepository.findAll(pageable);
    }
}
