package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.entity.Question;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;
import com.shop.dto.AnswerForm;

import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

/*
@Component : 일반 클래스를 빈 등록
@Controller : Controller 를 빈 등록
@Service : Service 를 빈 등록
@Repository : Repository 를 빈 등록
*/

@RequiredArgsConstructor
@Controller
public class AnswerController {
	// Client => controller => service => repository => entity => DB
	
	// 의존성 주입
    private final QuestionService questionService;
    private final AnswerService answerService;

    // 답변 등록 (유효성 검증 사용)
    @PostMapping("/answer/create/{id}")
    public String createAnswer(Model model, 
    		@PathVariable("id") Integer id,
            @Valid AnswerForm answerForm, 
            BindingResult bindingResult) {
        
        Question question = this.questionService.getQuestion(id);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }

        this.answerService.create(question, answerForm.getContent());

        return String.format("redirect:/question/detail/%s", id);
    }
}
