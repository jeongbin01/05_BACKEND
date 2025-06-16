package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.entity.Question;
import com.shop.service.QuestionService;

import lombok.RequiredArgsConstructor;

/*
@Component : 일반 클래스를 빈 등록
@Controller : Controller 클래스를 빈 등록
@Service : Service 클래스를 빈 등록
@Repository : Repository 클래스를 빈 등록
*/

// Controller 의 역할 : 1. client의 요청을 받는다. => 2. 비즈니스 로직 처리 => 3. 뷰 페이지 전송

@RequiredArgsConstructor
@Controller
public class QuestionController {

	//	MVC 모델로 처리
	//	client 요청 => Controller => Service => Repository => Entity => DB
		//	service : Controller 에서 Repository 를 직접 접근할 경우 보안 이슈 발생
			//	Controller 에서 직접 비즈니스 로직을 구현할 경우 중복코드 발생
			//	Service 에 비즈니스 로직을 위임하면 코드 재사용성과 보안성 강화 가능
			// 유지 보수를 쉽게 할 수 있다.

	private final QuestionService questionService;

    @GetMapping("/question/list")  // http://localhost:8082/question/list
    public String list(Model model) {

        // 2. 비즈니스 로직 처리 (Service 호출)
        List<Question> questions = questionService.getList();

        // 3. 모델 객체에 변수의 값을 담아서 클라이언트 페이지로 전송
        model.addAttribute("questionList", questions);

        // 4. 뷰 페이지 전송
//        System.out.println("컨트롤러 요청 성공");
        return "question_list";
    }
}

//               question 서비스 잘 요청