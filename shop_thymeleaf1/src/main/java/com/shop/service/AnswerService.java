package com.shop.service;

import com.shop.entity.Question;
import com.shop.entity.Answer;
import com.shop.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    //	답글 등록(insert , update , delete 리턴이 없다. ), (select 인 경우는 select 한 값을 동려 줘야한다.)
    public void create(Question question, String content) {
        Answer a = new Answer();
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        a.setQuestion(question);
        this.answerRepository.save(a);
        
        System.out.println("답변이 성공적으로 잘 작동");
    }
}

