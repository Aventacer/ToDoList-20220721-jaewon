package com.springboot.todolist.service.content;

import com.springboot.todolist.web.dto.content.CreateContentRequestDto;
import com.springboot.todolist.web.dto.content.CreateContentResponseDto;

public interface ContentService {
	public CreateContentResponseDto createContent(CreateContentRequestDto contentRequestDto) throws Exception;
	//public ReadContentResponseDto readContent(int contentcode) throws Exception;
}
