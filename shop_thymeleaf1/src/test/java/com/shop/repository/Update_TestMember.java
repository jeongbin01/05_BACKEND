package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Update_TestMember {

	@Autowired
	TestMemberRepository testMemberRepository;
	
	@Test
    void updateTestMember() {
        // 1) ID가 Long 타입이라면 99L로 넘겨야 합니다
        Optional<Test_Member> tm = testMemberRepository.findById(99);

        if (tm.isPresent()) {
            Test_Member t = tm.get();

            // 2) 수정 전 값 출력
            System.out.println("기존 ID       : " + t.getId());
            System.out.println("기존 이름     : " + t.getName());
            System.out.println("기존 생성일시 : " + t.getCreateDate());

            // 3) 이름 변경 (setName)
            t.setName("수정된 - 99번");

            // 4) 저장 (업데이트)
            testMemberRepository.save(t);

            // 5) 수정 후 검증 출력
            System.out.println("수정 후 이름  : " + t.getName());
        }
	}
	
}
