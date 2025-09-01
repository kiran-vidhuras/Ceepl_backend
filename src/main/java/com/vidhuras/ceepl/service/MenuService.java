package com.vidhuras.ceepl.service;



import com.vidhuras.ceepl.dto.MenuRequestDto;
import com.vidhuras.ceepl.dto.MenuResponseDto;

import java.util.List;

public interface MenuService {
    MenuResponseDto addMenu(MenuRequestDto dto);
    List<MenuResponseDto> getAllMenus();
    void deleteMenu(Long id);

}
