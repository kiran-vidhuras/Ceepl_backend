package com.vidhuras.ceepl.dto;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class HomeServiceRequestDto {
    private String serviceName;
    private String icon;
    private String subName;
    private String description;
    private String status;
}
