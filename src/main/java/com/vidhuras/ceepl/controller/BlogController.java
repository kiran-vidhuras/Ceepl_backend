package com.vidhuras.ceepl.controller;


import com.vidhuras.ceepl.dto.BlogRequestDto;
import com.vidhuras.ceepl.dto.BlogResponseDto;
import com.vidhuras.ceepl.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public BlogResponseDto createBlog(
            @RequestPart("title") String title,
            @RequestPart("date") String date,
            @RequestPart("category") String category,
            @RequestPart("description") String description,
            @RequestPart("image") MultipartFile image) {

        BlogRequestDto dto = new BlogRequestDto();
        dto.setTitle(title);
        dto.setCategory(category);
        dto.setDescription(description);
        dto.setDate(LocalDate.parse(date));
        dto.setImage(image);

        return blogService.createBlog(dto);
    }

    @GetMapping("/all")
    public List<BlogResponseDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public BlogResponseDto getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "Blog deleted successfully!";
    }
}
