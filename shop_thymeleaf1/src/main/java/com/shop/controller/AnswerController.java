package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Question;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AnswerController {
	//	Client => controller => service => repository => entity => DB
	
	//	의존성 주입
    private final QuestionService questionService;
    private final AnswerService answerService;

    // 답변 등록
    @PostMapping("/answer/create/{id}")
    public String createAnswer(Model model, 
    		@PathVariable("id") Integer id,
            @RequestParam("content") String content) {
        Question q = this.questionService.getQuestion(id);
        this.answerService.create(q, content);

        return String.format("redirect:/question/detail/%s", id);
    }
}
