package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.SiteUser;

@SpringBootTest
public class UserRepository_Test {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void userRepositoryTest() {
		
		//Optional<SiteUser> findByusername(String username);
		
		Optional<SiteUser> s =
				userRepository.findByusername("번호1000");
		
		SiteUser su = new SiteUser();
		
		if(s.isPresent()) {
			su= s.get();
		}
		
		System.out.println(su.getId());
		System.out.println(su.getEmail());
		System.out.println(su.getUsername());
		System.out.println(su.getPassword());
	}
}
