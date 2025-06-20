package com.example.demo_gradle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Memver {
	
	private String name ;
	private String nicName ;
	private int age;
	private double weight;
	private String addr;
	
	//DTD : 데이터를 전송해주는 역할을 함. 롬복(lombok)으로 아래 내용의 매소드를 자동으로 처리
		// 기본 생성자 , 모든 필드의 값을 할당하는 생성자ㅡ
		// getter(), setter()
		// toString() 를 오버라이딩 함
}
