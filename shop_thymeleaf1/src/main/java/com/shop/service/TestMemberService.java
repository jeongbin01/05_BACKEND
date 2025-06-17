package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Test_Member;
import com.shop.repository.TestMemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestMemberService {

    private final TestMemberRepository testMemberRepository;

    // 전체 조회
    public List<Test_Member> getList() {
        return testMemberRepository.findAll();
    }

}
