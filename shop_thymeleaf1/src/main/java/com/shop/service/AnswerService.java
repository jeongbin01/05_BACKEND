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


    public void create(Question question, String content) {
        Answer a = new Answer();
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        a.setQuestion(question);
        this.answerRepository.save(a);
    }
}

