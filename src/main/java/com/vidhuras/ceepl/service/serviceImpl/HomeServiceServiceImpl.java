package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.HomeServiceRequestDto;
import com.vidhuras.ceepl.dto.HomeServiceResponse;
import com.vidhuras.ceepl.entity.HomeService;
import com.vidhuras.ceepl.repository.HomeServiceRepository;
import com.vidhuras.ceepl.service.HomeServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeServiceServiceImpl implements HomeServiceService {

    private final HomeServiceRepository repository;

    @Override
    public HomeServiceResponse create(HomeServiceRequestDto requestDto, String createdBy, String ipAddress) {
        HomeService entity = new HomeService();
        entity.setServiceName(requestDto.getServiceName());
        entity.setIcon(requestDto.getIcon());
        entity.setSubName(requestDto.getSubName());
        entity.setDescription(requestDto.getDescription());
        entity.setStatus("ACTIVE");
        entity.setCreatedBy(createdBy);
        entity.setCreatedIp(ipAddress);
        entity.setCreatedOn(LocalDateTime.now());

        HomeService saved = repository.save(entity);

        return mapToResponseDto(saved);
    }

    @Override
    public List<HomeServiceResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public HomeServiceResponse getById(Long id) {
        HomeService entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HomeService not found with id: " + id));
        return mapToResponseDto(entity);
    }

    @Override
    public HomeServiceResponse update(Long id, HomeServiceRequestDto requestDto, String updatedBy, String ipAddress) {
        HomeService entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HomeService not found with id: " + id));

        entity.setServiceName(requestDto.getServiceName());
        entity.setIcon(requestDto.getIcon());
        entity.setSubName(requestDto.getSubName());
        entity.setDescription(requestDto.getDescription());
        entity.setModifiedBy(updatedBy);
        entity.setModifiedIp(ipAddress);
        entity.setModifiedOn(LocalDateTime.now());

        HomeService updated = repository.save(entity);
        return mapToResponseDto(updated);
    }

    @Override
    public void delete(Long id) {
        HomeService entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HomeService not found with id: " + id));
        repository.delete(entity);
    }

    // Helper method to map entity to response DTO
    private HomeServiceResponse mapToResponseDto(HomeService entity) {
        HomeServiceResponse dto = new HomeServiceResponse();
        dto.setId(entity.getId());
        dto.setServiceName(entity.getServiceName());
        dto.setIcon(entity.getIcon());
        dto.setSubName(entity.getSubName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatedOn(entity.getCreatedOn());
        dto.setCreatedBy(entity.getCreatedBy());

        return dto;
    }
}
