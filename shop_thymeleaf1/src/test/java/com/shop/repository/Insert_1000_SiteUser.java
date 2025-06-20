package com.shop.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.SiteUser;

@SpringBootTest
public class Insert_1000_SiteUser {

	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void insert1000SiteUser() {
		
		for(int i = 1; i <= 1000; i++) {
			SiteUser s = new SiteUser();
            s.setUsername("번호" + i);
            s.setEmail("번호" + i + "@example.com");
			
			userRepository.save(s);
		}
	}
}
