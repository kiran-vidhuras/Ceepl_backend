package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.ServiceRequestDto;
import com.vidhuras.ceepl.dto.ServiceResponseDto;
import com.vidhuras.ceepl.entity.ServiceEntity;
import com.vidhuras.ceepl.repository.ServiceRepository;
import com.vidhuras.ceepl.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceImpl implements NewService {

    private final ServiceRepository repository;

    @Autowired
    public ServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceResponseDto createService(String serviceName, String description, MultipartFile imageFile) {
        try {
            // Save file locally
            String uploadDir = "uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Save entity
            ServiceEntity entity = new ServiceEntity();
            entity.setServiceName(serviceName);
            entity.setDescription(description);
            entity.setImage(fileName); // save filename
            entity.setStatus("ACTIVE");
            entity.setCreatedOn(LocalDateTime.now());
            entity.setCreatedIp("127.0.0.1");
            entity.setCreatedBy("system");

            ServiceEntity saved = repository.save(entity);

            // Prepare response
            ServiceResponseDto response = new ServiceResponseDto();
            response.setId(saved.getId());
            response.setServiceName(saved.getServiceName());
            response.setDescription(saved.getDescription());
            response.setImage("http://localhost:8080/uploads/" + saved.getImage());
            response.setCreatedOn(saved.getCreatedOn());
            response.setCreatedIp(saved.getCreatedIp());
            response.setCreatedBy(saved.getCreatedBy());
            response.setStatus(saved.getStatus());

            return response;

        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @Override
    public List<ServiceResponseDto> getAllServices() {
        List<ServiceEntity> entities = repository.findAll();
        return entities.stream().map(saved -> {
            ServiceResponseDto dto = new ServiceResponseDto();
            dto.setId(saved.getId());
            dto.setServiceName(saved.getServiceName());
            dto.setDescription(saved.getDescription());
            dto.setImage("http://localhost:8080/uploads/" + saved.getImage());
            dto.setCreatedOn(saved.getCreatedOn());
            dto.setCreatedIp(saved.getCreatedIp());
            dto.setCreatedBy(saved.getCreatedBy());
            dto.setStatus(saved.getStatus());
            return dto;
        }).toList();
    }
}
