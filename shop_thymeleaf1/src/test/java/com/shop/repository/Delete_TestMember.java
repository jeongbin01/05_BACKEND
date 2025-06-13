package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Delete_TestMember {

	@Autowired
	TestMemberRepository testMemberRepository;
	
	@Test
	void DeleteTestMember() {
		Test_Member t = new Test_Member();
		
		Optional<Test_Member> tm = 
				testMemberRepository.findById(99);
		
		if(tm.isPresent()) {
			t = tm.get();
		}
		
		testMemberRepository.delete(t);
	}
}
