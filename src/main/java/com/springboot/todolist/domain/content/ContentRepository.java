package com.springboot.todolist.domain.content;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentRepository {
	public int save(Content content);
	public Content findContentByContentcode(int contentcode);
	public List<Content> getContentListOfIndex(int index);
}
