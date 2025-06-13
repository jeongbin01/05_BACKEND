package com.shop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Select_AII_Question {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void selectAllQuestion() {
        // 1) findAll() 결과를 List<Question>에 담는다
        List<Question> questionList = questionRepository.findAll();

        // 2) 레코드 개수 출력
        System.out.println("레코드의 갯수 : " + questionList.size());
        
        Question q = new Question();
        
        System.out.println("===For 문을 사용해서 출력===");
        // 3) for-each 로 각 Question 출력
        for (int i = 0; i < questionList.size(); i++) {
        	q = questionList.get(i);
            System.out.println(q.getId() + "\t");
            System.out.println(q.getSubject() + "\t");
            System.out.println(q.getContent() + "\t");
            System.out.println(q.getCreateDate());
            System.out.println();
        }
        System.out.println("===Enhanced For 문으로 출력===");
        for (Question q1 : questionList) {
        	System.err.println(q1.getId() + "\t");
        	System.out.println(q1.getSubject() + "\t");
        	System.out.println(q1.getContent() + "\t");
        	System.out.println(q1.getCreateDate());
        	System.out.println();
        }
    }
}