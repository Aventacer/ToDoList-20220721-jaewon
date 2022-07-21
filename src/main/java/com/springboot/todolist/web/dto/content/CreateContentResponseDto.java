package com.springboot.todolist.web.dto.content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateContentResponseDto {
	private int contentcode;
	private String content;
	private int usercode;
	private boolean insertStatus;
}
