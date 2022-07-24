package com.springboot.todolist.web.controller.api.content;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.todolist.service.content.ContentService;
import com.springboot.todolist.web.dto.CMResponseDTO;
import com.springboot.todolist.web.dto.content.CreateContentRequestDto;
import com.springboot.todolist.web.dto.content.CreateContentResponseDto;
import com.springboot.todolist.web.dto.content.ReadContentResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class Contentcontroller {
	private final ContentService contentService;
	
	//작성
	@PostMapping("/content")
	public ResponseEntity<?> addContent(@RequestBody CreateContentRequestDto contentRequestDto){
		CreateContentResponseDto contentResponseDto = null;
		try {
			contentResponseDto = contentService.createContent(contentRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMResponseDTO<>(1, "추가 실패", contentResponseDto));
		}
		
		return ResponseEntity.ok().body(new CMResponseDTO<>(1, "추가 성공", contentResponseDto));
	}
	
	//조회
	@GetMapping("/content/{contentcode}")
	public ResponseEntity<?> getBoard(@PathVariable int contentcode){
		ReadContentResponseDto readContentResponseDto = null;
		System.out.println("testGet\n contentcode : " + contentcode);
		try {
			System.out.println("try");
			readContentResponseDto = contentService.readContent(contentcode);
		} catch (Exception e) {
			System.out.println("catch");
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMResponseDTO<>(-1, "조회 실패", readContentResponseDto));
		}
		System.out.println("last return");
		return ResponseEntity.ok().body(new CMResponseDTO<>(1, "조회 성공", readContentResponseDto));	
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getcontentList(@RequestParam int page){
		List<ReadContentResponseDto> contentDtoList = null;
		System.out.println("list page : " + page);
		
		try {
			contentDtoList = contentService.readContentList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMResponseDTO<>(-1,"list fail", contentDtoList));
		}
		return ResponseEntity.ok().body(new CMResponseDTO<>(1,"list success", contentDtoList));
	}
}
