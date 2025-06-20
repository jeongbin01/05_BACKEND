package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        	// 예외를 강제로 발생 시킴 
            throw new DataNotFoundException("질문 테이터를 찾지 못했습니다.");
        }
    }
    
    // 질문 등록
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
    
    //	질문 리스트 (페이징 처리함)
    public Page<Question> getList(int page) {
    	
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
    	
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

}
