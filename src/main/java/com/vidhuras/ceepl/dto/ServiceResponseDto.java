package com.vidhuras.ceepl.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServiceResponseDto {
    private Long id;
    private String serviceName;
    private String image;
    private String description;
    private LocalDateTime createdOn;
    private String createdIp;
    private String createdBy;
    private LocalDateTime modifiedOn;
    private String modifiedIp;
    private String modifiedBy;
    private String status;
}

