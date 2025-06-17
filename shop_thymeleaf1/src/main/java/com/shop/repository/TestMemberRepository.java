package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Test_Member;

@Repository
public interface TestMemberRepository extends JpaRepository<Test_Member , Integer> {

}
