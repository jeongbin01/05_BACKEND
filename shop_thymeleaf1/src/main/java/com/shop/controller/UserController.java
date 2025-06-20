package com.shop.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import org.springframework.data.domain.Page;

import com.shop.dto.UserCreateForm;
import com.shop.entity.SiteUser;
import com.shop.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    
    private final UserService userService; 
    
    // 회원가입 폼
    @GetMapping("/signup")
    public String signupForm(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String processSignup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        try {
            userService.create(userCreateForm.getUsername(), 
                                userCreateForm.getEmail(), 
                                userCreateForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    // 회원 리스트 페이징
    @GetMapping("/list")
    public String userList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<SiteUser> userPage = userService.getUserList(page);
        model.addAttribute("userPage", userPage);
        return "user_list";
    }
}
