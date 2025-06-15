package com.shop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Select_All_TestMember {

    @Autowired
    private TestMemberRepository testMemberRepository;

    @Test
    void selectAllTestMember() {
        List<Test_Member> tm = testMemberRepository.findAll();
        for (Test_Member t : tm) {
            System.out.println(t.getId() + " / " + t.getName() + " / " + t.getPhone());
        }
    }
}
