package com.vidhuras.ceepl.service;
import com.vidhuras.ceepl.dto.AboutRequestDto;
import com.vidhuras.ceepl.dto.AboutResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AboutService {
    List<AboutResponseDto> findAll();
    AboutResponseDto add(AboutRequestDto dto);
    AboutResponseDto addAbout(AboutRequestDto dto);

    AboutResponseDto update(Long id, AboutRequestDto dto);

    boolean delete(Long id);
}
