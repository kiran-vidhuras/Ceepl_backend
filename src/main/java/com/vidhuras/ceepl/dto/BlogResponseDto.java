package com.vidhuras.ceepl.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BlogResponseDto {
    private Long id;
    private String title;
    private String image;
    private LocalDate date;
    private String category;
    private String description;
    private String status;
}
