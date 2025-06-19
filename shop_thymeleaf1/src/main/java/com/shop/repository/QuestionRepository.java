package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Question;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	// Repository : DAO 를 ORM에서는 Repository 라고 호칭한다.
	// Question : 테이블을 CRUD 하는 메소드가 자동으로 JpaRepository 인터페이스에서 상속받아서 내려온다.
		//	매소드를 사용해서 DB의 테이블에 쿼리를 보낸다.
		// DAO : DataBase의 테이블의 쿼리(CRUD) 적용 메소드를 담은 클래스 , 
				// DB 의 테이블을 직접 접근 하는 객체
		// ORA : 자바의 객체를 DB 의 테이블과 연결하는 기술 , MyBaties , JPA
	
	// JpeRepository 에서 상속 받아오느 메소드
	/*
	 		findAll()		: select * from Question;
	 		findByid(1)		: select * from Question where id = 1;
	 		save()			: insert , update 
	 		delete() 		: delete
	 */
	
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
}
