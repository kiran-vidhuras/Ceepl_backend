package com.vidhuras.ceepl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class TeamMemberRequestDto {
    private String name;
    private String designation;
    private MultipartFile image; // not String
}