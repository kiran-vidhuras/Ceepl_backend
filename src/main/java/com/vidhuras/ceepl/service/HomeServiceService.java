package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.HomeServiceRequestDto;
import com.vidhuras.ceepl.dto.HomeServiceResponse;

import java.util.List;

public interface HomeServiceService {
    HomeServiceResponse create(HomeServiceRequestDto requestDto, String system, String remoteAddr);

    List<HomeServiceResponse> getAll();

    HomeServiceResponse getById(Long id);

    HomeServiceResponse update(Long id, HomeServiceRequestDto requestDto, String system, String remoteAddr);

    void delete(Long id);
}
