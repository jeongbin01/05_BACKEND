package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.dto.QuestionForm;
import com.shop.entity.Question;
import com.shop.service.QuestionService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;

/*
@Component : 일반 클래스를 빈 등록
@Controller : Controller 를 빈 등록
@Service : Service 클래스를 빈 등록
@Repository : Repository 를 빈 등록
*/

// Controller 의 역할 : 1. client의 요청을 받는다. => 2. 비즈니스 로직 처리 => 3. 뷰 페이지 전송

@RequiredArgsConstructor
@Controller
public class QuestionController {

    // MVC 모델로 처리
    // client 요청 => Controller => Service => Repository => Entity => DB
    // service : Controller 에서 Repository 를 직접 접근할 경우 보안 이슈 발생
    // Controller 에서 직접 비즈니스 로직을 구현할 경우 중복코드 발생
    // Service 에 비즈니스 로직을 위임하면 코드 재사용성과 보안성 강화 가능
    // 유지 보수를 쉽게 할 수 있다.

    private final QuestionService questionService;

    @GetMapping("/question/list")  // http://localhost:8082/question/list
    public String list(Model model) {
        List<Question> questions = questionService.getList();
        model.addAttribute("questionList", questions);
        return "question_list";
    }

    // 질문 상세 페이지
    @GetMapping("/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question q = questionService.getQuestion(id);
        model.addAttribute("question", q);
        return "question_detail";
    }

    // 질문 등록 폼 화면
    @GetMapping("/question/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    
    // 질문 등록 처리
    @PostMapping("/question/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
