package com.shop.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Insert_100_TestMember {

    @Autowired
    TestMemberRepository testMemberRepository;

    @Test
    void insert100_testMember() {
        for (int i = 1; i <= 100; i++) {
            Test_Member tm = new Test_Member();
            tm.setName("회원" + i);
            tm.setPhone("010-0000-" + String.format("%04d", i));
            tm.setAge(20 + (i % 10));
            tm.setCreateDate(LocalDateTime.now());
            testMemberRepository.save(tm);
        }
    }
}
