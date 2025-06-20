// src/main/java/com/shop/repository/AnswerRepository.java
package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    // jpaRepository 에서 Answer Entity를 CRUD 하는 메소드가 상속됨
    // FindAll(), FindById(), save(), delete()
    Page<Answer> findAllByQuestion(Question question, Pageable pageable);
}
