package com.vidhuras.ceepl.dto;


import lombok.Data;

@Data
    public class ContactRequestDto {
        private String fullName;
        private String email;
        private String phone;
        private String state;
        private String district;
        private String country;
        private String message;
    }

