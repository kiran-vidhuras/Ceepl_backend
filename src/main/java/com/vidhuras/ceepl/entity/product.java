package com.vidhuras.ceepl.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "add_product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sub_product")
    private String subProduct;

    @Column(name = "key_benfits")
    private String keyBenefits;

    @Column(name = "sub_image")
    private String subImage;

    @Column(name = "sub_description")
    private String subDescription;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "creaated_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_ip")
    private String createdIp;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_ip")
    private String modifiedIp;

    @Column(name = "amount")
    private BigDecimal amount;


}




