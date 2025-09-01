package com.vidhuras.ceepl.controller;

import com.vidhuras.ceepl.dto.productRequestDto;
import com.vidhuras.ceepl.dto.productResponseDto;
import com.vidhuras.ceepl.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class productController {

    public final productService service;

    @Autowired
    public productController(productService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public productResponseDto createProduct(
            @RequestParam("productName") String productName,
            @RequestParam("companyName") String companyName,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            @RequestParam(value = "subImage", required = false) MultipartFile subImage,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "keyBenefits", required = false) String keyBenefits,
            @RequestParam(value = "subDescription", required = false) String subDescription,
            @RequestParam(value = "shortName", required = false) String shortName,
            @RequestParam(value = "amount", required = false) Double amount
    ) {
        return service.addProduct(productName, companyName, description, image,
                quantity, keyBenefits, subImage, subDescription, shortName, amount);
    }


    @PostMapping("/addSubProduct")
    public productResponseDto addSubProduct(
            @RequestParam("productName") String productName,
            @RequestParam("companyName") String companyName,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "keyBenefits", required = false) String keyBenefits,
            @RequestParam(value = "shortName", required = false) String shortName,
            @RequestParam(value = "amount", required = false) Double amount
    ) {
        return service.addSubProduct(productName, companyName, description,
                image, quantity, keyBenefits, shortName, amount);
    }

    @GetMapping("/allSubProduct")
    public List<productResponseDto> getAllSubProducts() {
        return service.getAllSubProducts();
    }

    @GetMapping("/allProduct")
    public List<productResponseDto> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/allProduct/{id}")
    public productResponseDto getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }
}
