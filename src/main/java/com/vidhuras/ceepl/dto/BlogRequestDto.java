package com.vidhuras.ceepl.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
public class BlogRequestDto {
    private String title;
    private MultipartFile image;
    private LocalDate date;
    private String category;
    private String description;
}
