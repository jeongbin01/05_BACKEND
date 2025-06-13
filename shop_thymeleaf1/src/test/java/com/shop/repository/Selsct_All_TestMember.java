package com.shop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Test_Member;

@SpringBootTest
public class Selsct_All_TestMember {

    @Autowired
    private TestMemberRepository testMemberRepository;
    
    @Test
    void selectAllTestMember() {
        // 1) 전체 조회
        List<Test_Member> members = testMemberRepository.findAll();
        
        // 2) 레코드 개수 출력
        System.out.println("레코드의 갯수 : " + members.size());
        
        System.out.println("=== for 문 사용해서 출력 ===");
        // 3) for 루프 돌면서 각 필드 출력
        for (int i = 0; i < members.size(); i++) {
            Test_Member m = members.get(i);
            System.out.print(m.getId() + "\t");
            System.out.print(m.getName() + "\t");
            System.out.print(m.getPhone() + "\t");
            System.out.print(m.getAge() + "\t");
            System.out.println(m.getCreateDate());
        }
    }
}
