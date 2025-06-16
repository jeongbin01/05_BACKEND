package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootApplication
public class Insert_Answer {

    private final TestMemberRepository testMemberRepository;

	// 답변 테이블에 값넣기
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository anwerAnswerRepository;


    Insert_Answer(TestMemberRepository testMemberRepository) {
        this.testMemberRepository = testMemberRepository;
    }
	
	
	
	@Test
	void insertAnswer() {
		
		// 1. 답변 테이블에 값을 넣기 위해서는 어떤 질문에 대한 답변인지 가지고 와야한다.
		// 		답변을 저장 할 Question 객체를 먼저 가져와야 한다.
		
		Optional<Question> oq = questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			
			// 2. Answer 객체에 setter를 사용해서 답글을 입력한다
			Answer a = new Answer();
			a.setContent("1번질문에 대한 답변입니다.");
			a.setCreateDate(LocalDateTime.now());
			a.setQuestion(q);
			
			anwerAnswerRepository.save(a);
		}
		
	}
}
