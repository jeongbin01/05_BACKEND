package com.example.demo_gradle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 스프링 프레임워크에서 객체를 자동으로 생성해서 컨테이너에 등록
public class HellowController {
	
	
	//개발자가 객채 생성
	//HellowController hello = new HellowController();
	
	@GetMapping("/")		//http://localhost:8081/
	@ResponseBody
	public String hello() {
		
		return "index";
	}
	
	@GetMapping("/world") 	//http://localhost:8081/world
	@ResponseBody				// JSON 문자열로 변환해서 돌러줌
	public String wold() {
		return "world 입니다.";
	}
	
	@GetMapping("/board") 	//http://localhost:8081/board
	//@ResponseBody
	public String board() {
		return "board.html";		//static/board.html 파일을 리턴돌려 줌
	}						// 만약에 thymeleaf 라이브러리가 설치되면 templares/board.html
	
	@GetMapping("/qna")		//http://localhost:8081/board
	@ResponseBody
	public String qna() {
		return "qna.html";		//static/qna.html
	}
	
	@GetMapping("/notice")
	@ResponseBody
	public String notice() {
		return "notice.html";
	}
}

