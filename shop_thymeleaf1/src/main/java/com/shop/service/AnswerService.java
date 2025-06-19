// src/main/java/com/shop/service/AnswerService.java
package com.shop.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.repository.AnswerRepository;

import lombok.RequiredArgsConstructor;

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

    //	답글 리스트 (페이징 처리)
    public Page<Answer> getList(Question question, int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.answerRepository.findAllByQuestion(question, pageable);
    }
}
