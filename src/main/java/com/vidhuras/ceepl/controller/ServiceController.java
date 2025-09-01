package com.vidhuras.ceepl.controller;


import com.vidhuras.ceepl.dto.ServiceRequestDto;
import com.vidhuras.ceepl.dto.ServiceResponseDto;
import com.vidhuras.ceepl.service.NewService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    private final NewService service;

    public ServiceController(NewService service) {
        this.service = service;
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ServiceResponseDto> createService(
            @RequestParam String serviceName,
            @RequestParam String description,
            @RequestParam MultipartFile imageFile) {

        ServiceResponseDto response = service.createService(serviceName, description, imageFile);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceResponseDto>> getAllServices() {
        List<ServiceResponseDto> services = service.getAllServices();
        return ResponseEntity.ok(services);
    }
}

