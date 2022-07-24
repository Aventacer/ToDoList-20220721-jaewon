package com.springboot.todolist.service.content;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.todolist.domain.content.Content;
import com.springboot.todolist.domain.content.ContentRepository;
import com.springboot.todolist.web.dto.content.CreateContentRequestDto;
import com.springboot.todolist.web.dto.content.CreateContentResponseDto;
import com.springboot.todolist.web.dto.content.ReadContentResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService{

	private final ContentRepository contentRepository;
	
	@Override
	public CreateContentResponseDto createContent(CreateContentRequestDto createContentRequestDto) throws Exception {
	
		Content contentEntity = createContentRequestDto.toEntity();
		
		boolean insertStatus = contentRepository.save(contentEntity) > 0;
		
		return contentEntity.toCreateContentDto(insertStatus);
	}

	@Override
	public ReadContentResponseDto readContent(int contentcode) throws Exception {
		return contentRepository.findContentByContentcode(contentcode).toReadContentDto();
	}

	@Override
	public List<ReadContentResponseDto> readContentList(int page) throws Exception {
		List<ReadContentResponseDto> contentDtoList = new ArrayList<ReadContentResponseDto>();
		
		contentRepository.getContentListOfIndex((page - 1) * 10).forEach(content -> {
			contentDtoList.add(content.toReadContentDto());
		});
		return contentDtoList;
	}

}
