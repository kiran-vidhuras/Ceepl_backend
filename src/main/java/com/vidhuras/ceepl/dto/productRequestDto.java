package com.vidhuras.ceepl.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class productRequestDto {

    private String productName;
    private String companyName;
    private String description;
    private String image;
    private int quantity;
    private String subProduct;
    private String keyBenefits;
    private String subImage;
    private String subDescription;
    private String shortName;
    private BigDecimal amount;
}
