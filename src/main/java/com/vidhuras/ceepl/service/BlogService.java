package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.BlogRequestDto;
import com.vidhuras.ceepl.dto.BlogResponseDto;

import java.util.List;

public interface BlogService {
    BlogResponseDto createBlog(BlogRequestDto dto);
    List<BlogResponseDto> getAllBlogs();
    BlogResponseDto getBlogById(Long id);
    void deleteBlog(Long id);
}
