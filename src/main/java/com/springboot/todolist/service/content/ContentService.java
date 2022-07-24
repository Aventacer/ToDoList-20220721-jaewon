package com.springboot.todolist.service.content;

import java.util.List;

import com.springboot.todolist.web.dto.content.CreateContentRequestDto;
import com.springboot.todolist.web.dto.content.CreateContentResponseDto;
import com.springboot.todolist.web.dto.content.ReadContentResponseDto;

public interface ContentService {
	public CreateContentResponseDto createContent(CreateContentRequestDto contentRequestDto) throws Exception;
	public ReadContentResponseDto readContent(int contentcode) throws Exception;
	public List<ReadContentResponseDto> readContentList(int page) throws Exception;
}
