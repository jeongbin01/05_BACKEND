package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Insert1000_Question {

    @Autowired
    QuestionRepository questionRepository;
    
    @Test
    void insert1000Question() {
        
        for(int i = 1; i <= 1000; i++) {
            Question q = new Question();
            q.setSubject("제목 : " + i);
            q.setContent("내용 : " + i);
            q.setCreateDate(LocalDateTime.now());
            questionRepository.save(q);
        }
    }
}
