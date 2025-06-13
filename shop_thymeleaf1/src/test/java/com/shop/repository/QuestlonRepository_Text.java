package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class QuestlonRepository_Text {
	
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;
	
	@Test
	void insertText() {
		// Question 객체
		Question q1 = new Question();
		Answer a1 = new Answer();
		
		// 객체에 값을 입력 : setter
		q1.setSubject("JPA가 무엇인가요? - 제목");
		q1.setContent("JPA - 내용 ");
		q1.setCreateDate(LocalDateTime.now());
		
		a1.setContent("JPA는 ORM입니다.");
		a1.setCreateDate(LocalDateTime.now());
		
		// repository를 사용해서 DB에 저장
		this.questionRepository.save(q1);
		this.answerRepository.save(a1);
	}
}
