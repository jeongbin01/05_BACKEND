package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//	예외 처리 : 프로그램이 멈추지 않도록 처리
//	런타임 오류 : 프로그램이 실행 시 멈춤(오류가 발생)
//	컴파일 오류 : 코드를 작성 시 오류를 발생시

//	@ResponseStatus : 예외 발생 시 HTTP 상태코드를 명시적으로 지정
//	HttpStatus.NOT_FOUND : 404 에러를 반환
//	reason = "entity not found" : 사용자 정의 오류 메시지
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {  // ← 반드시 RuntimeException 상속
	private static final long serialVersionUID = 1L;

	//	생성자 : 예외 메시지를 상위 클래스(RuntimeException)에 전달
	public DataNotFoundException(String message) {
		super(message);
	}
}
