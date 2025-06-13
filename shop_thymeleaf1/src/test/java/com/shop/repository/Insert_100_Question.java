package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Insert_100_Question {

	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void insert100Question() {
		
		// q 의 내부의 존재하는 Question 객체를 끄집어 낸다.
		//Question q = new Question();
		
		for (int i = 1; i <= 100; i++) {
			Question q = new Question();
			
			q.setSubject("제목" + i);
			q.setContent("내용" + i);
			q.setCreateDate(LocalDateTime.now());
		
			questionRepository.save(q);
		}
		
	}
}
