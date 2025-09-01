package com.vidhuras.ceepl.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class productResponseDto {

    private Long productId;
    private String productName;
    private String companyName;
    private String description;
    private String image;
    private Integer quantity;
    private String keyBenefits;
    private String subImage;
    private String subDescription;
    private String shortName;
    private BigDecimal amount;
    private String createdBy;
    private String createdIp;
    private String modifiedBy;
    private String modifiedIp;


}



