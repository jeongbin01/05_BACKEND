package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Update_Question {

	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void updateQuestion() {
		// 1. DB에서 업데이트할 레코드를 가지고 온다. Question Entity에 담는다.
		Optional<Question> op = 
				questionRepository.findById(95);
		
		Question q = new Question(); 
		
		if (op.isPresent()) {
			q = op.get();
		} 
		
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		
		// 2. Question Entity의 setter로 수정
		q.setSubject("수정된 - 95번");
		q.setContent("수정된 - 내용 - 95번");
		
		// 3. Repository 의 save() 를 사용해서 저장
		questionRepository.save(q);		
		
	}
}
