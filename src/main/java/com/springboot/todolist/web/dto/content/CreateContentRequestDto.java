package com.springboot.todolist.web.dto.content;

import com.springboot.todolist.domain.content.Content;

import lombok.Data;

@Data
public class CreateContentRequestDto {
	private int usercode;
	private String content;
	
	public Content toEntity() {
		return Content.builder()
				.usercode(usercode)
				.content(content)
				.build();
	}
	
}
