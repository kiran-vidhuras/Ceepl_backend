package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.productResponseDto;
import com.vidhuras.ceepl.entity.product;
import com.vidhuras.ceepl.entity.subProducts;
import com.vidhuras.ceepl.repository.productRepository;
import com.vidhuras.ceepl.repository.subProductsRepository;
import com.vidhuras.ceepl.service.productService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class productServiceImpl implements productService {

    private final productRepository repository;
    private final subProductsRepository subProductRepo;

    public productServiceImpl(productRepository productRepo, subProductsRepository subProductRepo) {
        this.repository = productRepo;
        this.subProductRepo = subProductRepo;
    }

    @Override
    public productResponseDto addProduct(String productName,
                                         String companyName,
                                         String description,
                                         MultipartFile image,
                                         Integer quantity,
                                         String keyBenefits,
                                         MultipartFile subImage,
                                         String subDescription,
                                         String shortName,
                                         Double amount) {
        try {
            product entity = new product();
            entity.setProductName(productName);
            entity.setCompanyName(companyName);
            entity.setDescription(description);
            entity.setKeyBenefits(keyBenefits);


            if (image != null && !image.isEmpty()) {
                String imageUrl = saveFile(image);
                entity.setImage(imageUrl);
            }
            if (subImage != null && !subImage.isEmpty()) {
                String subImageUrl = saveFile(subImage);
                entity.setSubImage(subImageUrl);
            }

            entity.setCreatedOn(LocalDateTime.now());
            entity.setCreatedBy("system");
            entity.setCreatedIp("127.0.0.1");

            product saved = repository.save(entity);
            return convertToDto(saved);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }

    @Override
    public productResponseDto addSubProduct(String productName,
                                            String companyName,
                                            String description,
                                            MultipartFile image,
                                            Integer quantity,
                                            String keyBenefits,
                                            String shortName,
                                            Double amount) {
        try {
            subProducts entity = new subProducts();
            entity.setProductName(productName);
            entity.setCompanyName(companyName);
            entity.setDescription(description);


            if (image != null && !image.isEmpty()) {
                String imageUrl = saveFile(image);
                entity.setImage(imageUrl);
            }

            entity.setCreatedOn(LocalDateTime.now());
            entity.setCreatedBy("system");
            entity.setCreatedIp("127.0.0.1");

            subProducts saved = subProductRepo.save(entity);
            return convertToDto(saved);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add sub product", e);
        }
    }

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    private String saveFile(MultipartFile file) {
        if (file == null || file.isEmpty()) return null;
        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File dest = new File(uploadDir, filename);
            file.transferTo(dest);

            return "/uploads/" + filename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

    @Override
    public productResponseDto getProductById(Long id) {
        product entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return convertToDto(entity);
    }

    @Override
    public List<productResponseDto> getAllProducts() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<productResponseDto> getAllSubProducts() {
        return subProductRepo.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    private productResponseDto convertToDto(product entity) {
        productResponseDto response = new productResponseDto();
        response.setProductId(entity.getProductId());
        response.setProductName(entity.getProductName());
        response.setCompanyName(entity.getCompanyName());
        response.setDescription(entity.getDescription());
        response.setImage(entity.getImage());
        response.setKeyBenefits(entity.getKeyBenefits());

        return response;
    }

    private productResponseDto convertToDto(subProducts entity) {
        productResponseDto response = new productResponseDto();
        response.setProductId(entity.getProductId());
        response.setProductName(entity.getProductName());
        response.setCompanyName(entity.getCompanyName());
        response.setDescription(entity.getDescription());
        response.setImage(entity.getImage());

        return response;
    }
}
