package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Insert_1000_Answers {

    // 답글 저장용 리포지토리
    @Autowired
    private AnswerRepository answerRepository;

    // 질문 조회용 리포지토리
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void lnsert000Answers() {
        Question question = questionRepository.findById(1001)
            .orElseThrow(() -> new IllegalArgumentException("ID가 1001인 질문을 찾을 수 X")); // 예외 메시지를 더 명확하게 수정

        // 2) IntStream으로 1부터 1000까지 Answer 객체를 생성
        List<Answer> answers = IntStream.rangeClosed(1, 1000)
            .mapToObj(i -> {
                Answer a = new Answer();
                a.setContent("1001번 질문에 대한 테스트 답글 내용 " + i); // 내용도 일부 수정하여 구분
                a.setCreateDate(LocalDateTime.now());
                a.setQuestion(question); // 조회한 1001번 질문과 연결
                return a;
            })
            .collect(Collectors.toList());

        // 3) 한 번에 저장
        answerRepository.saveAll(answers);
    }
}