package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Select_by_99_TestMember {

    @Autowired
    private TestMemberRepository testMemberRepository;

    @Test
    void select99TestMember() {
        Optional<Test_Member> tm = testMemberRepository.findById(99);
        if (tm.isPresent()) {
            Test_Member t = tm.get();
            System.out.println("ID : " + t.getId());
            System.out.println("이름 : " + t.getName());
            System.out.println("전화번호 : " + t.getPhone());
            System.out.println("등록일 : " + t.getCreateDate());
        } else {
            System.out.println("99번 회원 없음");
        }
    }
}
