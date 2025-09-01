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

    private HomeServiceResponse toDto(HomeService entity) {
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

    @Override
    public HomeServiceResponse create(HomeServiceRequestDto requestDto, String createdBy, String createdIp) {
        HomeService entity = new HomeService();
        entity.setServiceName(requestDto.getServiceName());
        entity.setIcon(requestDto.getIcon());
        entity.setSubName(requestDto.getSubName());
        entity.setDescription(requestDto.getDescription());
        entity.setStatus(requestDto.getStatus());
        entity.setCreatedOn(LocalDateTime.now());
        entity.setCreatedBy(createdBy);
        entity.setCreatedIp(createdIp);

        return toDto(repository.save(entity));
    }

    @Override
    public List<HomeServiceResponse> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public HomeServiceResponse getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
    }

    @Override
    public HomeServiceResponse update(Long id, HomeServiceRequestDto requestDto, String modifiedBy, String modifiedIp) {
        HomeService entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));

        entity.setServiceName(requestDto.getServiceName());
        entity.setIcon(requestDto.getIcon());
        entity.setSubName(requestDto.getSubName());
        entity.setDescription(requestDto.getDescription());
        entity.setStatus(requestDto.getStatus());
        entity.setModifiedOn(LocalDateTime.now());
        entity.setModifiedBy(modifiedBy);
        entity.setModifiedIp(modifiedIp);

        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}



