package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity
public class TestEntity {
	
	// 데이블에서 반드시 primary key 컬럼이 존재ㅐ 해야 한다.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long idx ;

	@Column(length = 200)
	public String name;
	
	@Column(length = 20000)
	public String addr;
	
	public double weight;
	
	public int age;

}
