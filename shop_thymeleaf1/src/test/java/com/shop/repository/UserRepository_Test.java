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
				userRepository.findByusername("eee");
		
		SiteUser s1 = new SiteUser();
		
		if(s.isPresent()) {
			s1= s.get();
		}
		
		System.out.println(s1.getId());
		System.out.println(s1.getEmail());
		System.out.println(s1.getUsername());
		System.out.println(s1.getPassword());
	}
}
