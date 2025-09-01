package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.productRequestDto;
import com.vidhuras.ceepl.dto.productResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface productService {
    productResponseDto getProductById(Long id);
    List<productResponseDto> getAllProducts();

    productResponseDto addProduct(String productName, String companyName, String description, MultipartFile image, Integer quantity, String keyBenefits, MultipartFile subImage, String subDescription, String shortName, Double amount);


    List<productResponseDto> getAllSubProducts();

    productResponseDto addSubProduct(String productName, String companyName, String description, MultipartFile image, Integer quantity, String keyBenefits, String shortName, Double amount);
}
