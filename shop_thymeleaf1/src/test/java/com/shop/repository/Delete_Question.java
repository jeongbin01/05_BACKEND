package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Delete_Question {

	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void DeleteQuestion() {
		// 1. delete 할 레코드를 가지고 와서 Question q entity 에 넣는다.
		Question q = new Question();
		
		Optional<Question> op = 
				questionRepository.findById(100);
		
		if(op.isPresent()) {
			q = op.get();
		}
		
		// 2. Question 의 delete(q) 넣어서 제거
		questionRepository.delete(q);
	}
}
