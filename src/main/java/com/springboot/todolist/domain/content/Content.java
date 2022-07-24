package com.springboot.todolist.domain.content;

import java.time.LocalDateTime;

import com.springboot.todolist.web.dto.content.CreateContentResponseDto;
import com.springboot.todolist.web.dto.content.ReadContentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Content {
	private int contentcode;
	private String content;
	private int usercode;
	private String username;
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
	
	public ReadContentResponseDto toReadContentDto() {
		return ReadContentResponseDto.builder()
				.contentcode(contentcode)
				.content(content)
				.usercode(usercode)
				.username(username)
				.createdate(createdate)
				.build();
	}
}
