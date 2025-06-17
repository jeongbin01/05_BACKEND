package com.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.entity.Test_Member;
import com.shop.service.TestMemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestMemberController {

    private final TestMemberService testMemberService;

    @GetMapping("/testmember/list") // http://localhost:8082/testmember/list
    public String list(Model model) {
        List<Test_Member> memberList = testMemberService.getList();
        model.addAttribute("memberList", memberList);
        return "lab/TestMemberList"; // 반드시 이 이름과 html 파일 이름 일치
    }
}
