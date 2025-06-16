package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Question;
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    // question 테이블의 모든 값을 출력하는 메소드
    public List<Question> getList() {
        return questionRepository.findAll();
    }
}
