package com.shop.controller;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.shop.dto.AnswerForm;
import com.shop.dto.QuestionForm;
import com.shop.entity.Answer;
import com.shop.entity.Question;
import com.shop.entity.SiteUser;
import com.shop.service.AnswerService;
import com.shop.service.QuestionService;
import com.shop.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    // 질문 리스트 (페이징)
    @GetMapping("/question/list")
    public String list(Model model, 
                       @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Question> paging = questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    // 질문 상세 (댓글 페이징 포함)
    @GetMapping("/question/detail/{id}")
    public String detail(Model model,
                         @PathVariable("id") Integer id,
                         AnswerForm answerForm,
                         @RequestParam(value = "commentPage", defaultValue = "0") int commentPage) {
        Question q = questionService.getQuestion(id);
        model.addAttribute("question", q);

        Page<Answer> commentPaging = answerService.getList(q, commentPage);
        model.addAttribute("commentPaging", commentPaging);
        return "question_detail";
    }

    // 질문 작성 폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/question/create")
    public String showCreateForm(QuestionForm questionForm) {
        return "question_form";
    }

    // 질문 등록 처리
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/question/create")
    public String processCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult,
                                 Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = userService.getUser(principal.getName());
        questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list";
    }

    // 질문 수정 폼
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/question/modify/{id}")
    public String showModifyForm(@PathVariable("id") Integer id,
                                  QuestionForm questionForm,
                                  Principal principal) {
        Question question = questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        return "question_form";
    }

    // 질문 수정 처리
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/question/modify/{id}")
    public String processModify(@PathVariable("id") Integer id,
                                 @Valid QuestionForm questionForm,
                                 BindingResult bindingResult,
                                 Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
        }
        questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/detail/" + id;
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }

}
