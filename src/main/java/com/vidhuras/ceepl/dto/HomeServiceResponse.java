package com.vidhuras.ceepl.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HomeServiceResponse {
    private Long id;
    private String serviceName;
    private String icon;
    private String subName;
    private String description;
    private String status;
    private LocalDateTime createdOn;
    private String createdBy;
}
