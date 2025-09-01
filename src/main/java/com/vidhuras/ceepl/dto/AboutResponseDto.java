package com.vidhuras.ceepl.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class AboutResponseDto {
    private Long id;
    private String heading;
    private String description;
    private String buttonText;
    private String imagePath;
    private String content;
}