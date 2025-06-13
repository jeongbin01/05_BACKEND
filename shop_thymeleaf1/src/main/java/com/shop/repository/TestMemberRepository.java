package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Test_Member;


public interface TestMemberRepository extends JpaRepository<Test_Member , Integer> {

}
