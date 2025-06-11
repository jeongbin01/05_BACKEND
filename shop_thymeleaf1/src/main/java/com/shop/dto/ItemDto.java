package com.shop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ItemDto {
	
	// 상품 정보를 처리하느 Dto : client =>  dto => Ebtuty => DB
	private Long id;
	private String ItemNm;
	private Integer price;
	private String ItemDetail;
	private String SellStatCd;
	private LocalDateTime regTime;
	private LocalDateTime updatelime;
}
