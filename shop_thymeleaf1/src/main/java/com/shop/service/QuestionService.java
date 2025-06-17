package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.exception.DataNotFoundException;
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    //	question 테이블의 모든 값을 출력하는 메소드
    //	질문 리스트를 처리하는 매소드 
    public List<Question> getList() {
        return questionRepository.findAll();
    }

    //	질문 상세를 처리하는 매소드
    public Question getQuestion(Integer id) {
    	Optional<Question> q =
    			questionRepository.findById(id);
    	
    	//	Optional 의 Question 객체를 끄집어 낼 때 NULL 아닌 경우 끄집어 내야한다. 만약에 NULL인 경우 예외 처리 필요.
    	if (q.isPresent()) {
            return q.get();
        } else {
            throw new DataNotFoundException("질문 테이터를 찾지 못했습니다.");
        }
    }
}
