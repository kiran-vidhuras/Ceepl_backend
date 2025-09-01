package com.vidhuras.ceepl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberResponseDto {
    private String name;
    private String designation;
    private String image;
}