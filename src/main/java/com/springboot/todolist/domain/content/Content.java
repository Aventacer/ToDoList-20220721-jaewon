package com.springboot.todolist.domain.content;

import java.time.LocalDateTime;

import com.springboot.todolist.web.dto.content.CreateContentResponseDto;

public class Content {
	private int contentcode;
	private String content;
	private int usercode;
	private LocalDateTime createdate;
	private LocalDateTime updatedate;
	
	public CreateContentResponseDto toCreateContentDto(boolean insertStatus) {
		return CreateContentResponseDto.builder()
				.contentcode(contentcode)
				.content(content)
				.usercode(usercode)
				.insertStatus(insertStatus)
				.build();
	}
}
