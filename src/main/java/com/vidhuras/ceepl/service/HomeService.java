package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.HomeRequestDto;
import com.vidhuras.ceepl.dto.HomeResponseDto;
import com.vidhuras.ceepl.entity.HomeEntity;
import com.vidhuras.ceepl.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HomeService {

    List<HomeResponseDto> getAllSliders();

    HomeResponseDto getSliderById(Long id);



    void softDeleteSlider(Long id);

    HomeEntity saveHome(String title, String subTitle, MultipartFile image) throws IOException;
    HomeResponseDto addSlider(HomeRequestDto dto);
    String saveFile(MultipartFile image) throws IOException;


    HomeResponseDto updateSliderFull(Long id, HomeRequestDto dto);

    HomeResponseDto updateSliderPartial(Long id, HomeRequestDto dto);
}

