package com.vidhuras.ceepl.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AboutRequestDto {
    private String heading;
    private String description;
    private String buttonText;
    private String imagePath;
    private String content;

}