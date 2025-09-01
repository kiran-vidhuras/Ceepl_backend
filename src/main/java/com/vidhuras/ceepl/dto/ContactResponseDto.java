package com.vidhuras.ceepl.dto;





import lombok.Data;

import java.time.LocalDateTime;

@Data
    public class ContactResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String message;
    private String status;

    }

