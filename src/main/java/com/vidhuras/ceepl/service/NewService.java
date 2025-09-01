package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.ServiceRequestDto;
import com.vidhuras.ceepl.dto.ServiceResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewService {

    ServiceResponseDto createService(String serviceName, String description, MultipartFile imageFile);

    List<ServiceResponseDto> getAllServices();
}
