package com.example.demo.productregist.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class productCreateForm {
	
	@NotEmpty(message = "상품명 필수항목 입니다.")
	private String name;
	
	@NotEmpty(message = "카테고리는 필수항목 입니다.")
	private String category;
	
	@NotNull(message = "가격은 필수항목 입니다.")
	private Integer price;
	
	@NotNull(message = "수량은 필수항목 입니다.")
	private Integer amount;
	
	@NotEmpty(message = "상품 이미지는 필수항목 입니다.")
	private String path;
	
	@NotEmpty(message = "상세설명은 필수항목 입니다.")
	private String explan;
	
	
	
}
