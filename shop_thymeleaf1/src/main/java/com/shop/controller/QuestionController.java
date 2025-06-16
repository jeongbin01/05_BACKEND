package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.entity.Question; // ✅ 이걸 import 해야 함
import com.shop.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

/*
@Component : 일반 클래스를 빈 등록
@Controller : Controller 클래스를 빈 등록
@Service : Service 클래스를 빈 등록
@Repository : Repository 클래스를 빈 등록
*/

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")  // http://localhost:8082/question/list
    public String list(Model model) {
        System.out.println("컨트롤러 요청 성공");

        // 2. 비즈니스 로직 처리: 모든 질문 가져오기
        List<Question> questions = questionRepository.findAll();

        // 3. 모델에 데이터 담기
        model.addAttribute("questionList", questions);

        // 4. 뷰 페이지 반환
        return "question_list";
    }
}
