package com.vidhuras.ceepl.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponseDto {
    private Long id;
    private String name;
    private String link;
    private String status;
    private String subName;
}
