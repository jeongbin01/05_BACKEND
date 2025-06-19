package com.shop.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.dto.AnswerForm;
import com.shop.dto.QuestionForm;
import com.shop.entity.Question;
import com.shop.service.QuestionService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;

/*
@Component : 일반 클래스를 빈으로 등록
@Controller : Controller 클래스를 빈으로 등록
@Service : Service 클래스를 빈으로 등록
@Repository : Repository 클래스를 빈으로 등록
*/

// Controller 의 역할: 1. Client의 요청 수신 → 2. 비즈니스 로직 처리 → 3. 뷰 반환

@RequiredArgsConstructor
@Controller
public class QuestionController {

    // MVC 패턴: Client → Controller → Service → Repository → Entity → DB
    // Service를 사용하는 이유:
    // - 보안상 Repository를 직접 접근하지 않음
    // - 비즈니스 로직을 Service에 위임하여 재사용성과 유지보수성 증가

    private final QuestionService questionService;

    // 질문 리스트 (페이징 적용)
    @GetMapping("/question/list")  // http://localhost:8082/question/list
    public String list(Model model, 
            @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        
        
        model.addAttribute("paging", paging);
        return "question_list";
    }

    // 질문 상세 보기 (질문 1개 조회 + 답변 입력 폼 표시)
    @GetMapping("/question/detail/{id}")
    public String detail(Model model, 
            @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question q = questionService.getQuestion(id);
        if (q == null) {
            return "error/404";  // 만약 질문이 없을 경우 (간단 예외 처리)
        }
        model.addAttribute("question", q);
        return "question_detail";
    }

    // 질문 등록 폼
    @GetMapping("/question/create")
    public String showQuestionCreateForm(QuestionForm questionForm) {
        return "question_form";
    }

    // 질문 등록 처리
    @PostMapping("/question/create")
    public String processQuestionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
                
    }
}
