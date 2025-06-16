package com.shop.repository;

import java.util.List;
import java.util.Optional;

import com.shop.entity.Answer;
import com.shop.entity.Question;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Select_AnswerList {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    @Transactional
    void selectAnswerList() {
        // 1번 질문에 대한 답변들 출력
        Optional<Question> oq = questionRepository.findById(1);

        if (oq.isPresent()) {
            Question q = oq.get();

            // 질문 정보 출력
            System.out.println(q.getId());
            System.out.println(q.getCreateDate());
            System.out.println(q.getSubject());
            System.out.println(q.getContent());
            System.out.println("========================");

            // 답변 리스트 출력
            List<Answer> answList = q.getAnswerList();
            System.out.println("=== 답변 내용 출력 ===");

            for (int i = 0; i < answList.size(); i++) {  
                Answer a = answList.get(i);
                System.out.println("아이디 : " + a.getId());
                System.out.println("내용 : " + a.getContent());
                System.out.println("날짜 : " +  a.getCreateDate());
                System.out.println();
            }
        }
    }
}
