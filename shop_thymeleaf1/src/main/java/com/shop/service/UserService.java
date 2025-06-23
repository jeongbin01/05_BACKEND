package com.shop.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.shop.entity.SiteUser;
import com.shop.repository.UserRepository;
import com.shop.exception.DataNotFoundException;

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
    
    // principal 에서 현재 로그온한 username 을 읽어와서 suteUser 객체를 리턴 받는 메소드
    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }
}
