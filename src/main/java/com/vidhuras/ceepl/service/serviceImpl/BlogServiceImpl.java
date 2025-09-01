package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.BlogRequestDto;
import com.vidhuras.ceepl.dto.BlogResponseDto;
import com.vidhuras.ceepl.entity.Blog;
import com.vidhuras.ceepl.repository.BlogRepository;
import com.vidhuras.ceepl.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogResponseDto createBlog(BlogRequestDto dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setCategory(dto.getCategory());
        blog.setDescription(dto.getDescription());
        blog.setDate(dto.getDate());
        blog.setStatus("ACTIVE");

        MultipartFile file = dto.getImage();
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String uploadDir = new File("uploads").getAbsolutePath();
        File uploadPath = new File(uploadDir);

        if (!uploadPath.exists()) uploadPath.mkdirs();

        try {
            file.transferTo(new File(uploadPath, fileName));
            blog.setImage("/uploads/" + fileName); // Save accessible path in DB
        } catch (IOException e) {
            throw new RuntimeException("File upload failed!", e);
        }

        Blog saved = blogRepository.save(blog);
        return mapToResponse(saved);
    }

    @Override
    public List<BlogResponseDto> getAllBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BlogResponseDto getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        return mapToResponse(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    // Only one mapToResponse method
    private BlogResponseDto mapToResponse(Blog blog) {
        BlogResponseDto dto = new BlogResponseDto();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setImage(blog.getImage());
        dto.setDate(blog.getDate());
        dto.setCategory(blog.getCategory());
        dto.setDescription(blog.getDescription());
        dto.setStatus(blog.getStatus());
        return dto;
    }
}
