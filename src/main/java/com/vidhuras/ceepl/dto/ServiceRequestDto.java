package com.vidhuras.ceepl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServiceRequestDto {
    private Long id;

    @JsonProperty("seviceName")
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

