package com.vidhuras.ceepl.service.serviceImpl;


import com.vidhuras.ceepl.dto.MenuRequestDto;
import com.vidhuras.ceepl.dto.MenuResponseDto;
import com.vidhuras.ceepl.entity.Menu;
import com.vidhuras.ceepl.repository.MenuRepository;
import com.vidhuras.ceepl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuResponseDto addMenu(MenuRequestDto dto) {
        Menu menu = new Menu();
        menu.setName(dto.getName());
        menu.setSubName(dto.getSubName());
        menu.setLink(dto.getLink());
        menu.setStatus(dto.getStatus() != null ? dto.getStatus() : "ACTIVE");

        Menu saved = menuRepository.save(menu);
        return mapToResponse(saved);
    }


    @Override
    public List<MenuResponseDto> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    private MenuResponseDto mapToResponse(Menu menu) {
        return MenuResponseDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .subName(menu.getSubName())
                .link(menu.getLink())
                .status(menu.getStatus())
                .build();
    }
}

