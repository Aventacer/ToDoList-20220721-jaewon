package com.springboot.todolist.web.controller.api.content;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.service.content.ContentService;
import com.springboot.todolist.web.dto.content.CMResponseDTO;
import com.springboot.todolist.web.dto.content.CreateContentRequestDto;
import com.springboot.todolist.web.dto.content.CreateContentResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vi/content")
@RequiredArgsConstructor
public class Contentcontroller {
	private final ContentService contentService;
	
	public ResponseEntity<?> addContent(@RequestBody CreateContentRequestDto contentRequestDto){
		CreateContentResponseDto contentResponseDto = null;
		try {
			contentResponseDto = contentService.createContent(contentRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMResponseDTO<>(1, "t실패", contentResponseDto));
		}
		
		return ResponseEntity.ok().body(new CMResponseDTO<>(1, "", contentResponseDto));
	}
}
