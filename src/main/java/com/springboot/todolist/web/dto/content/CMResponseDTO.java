package com.springboot.todolist.web.dto.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMResponseDTO<T> {
	private int code;
	private String message;
	private T data;
	
}
