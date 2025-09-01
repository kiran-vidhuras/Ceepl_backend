package com.vidhuras.ceepl.controller;


import com.vidhuras.ceepl.dto.MenuRequestDto;
import com.vidhuras.ceepl.dto.MenuResponseDto;
import com.vidhuras.ceepl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@CrossOrigin(origins = "http://localhost:5500")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/add")
    public MenuResponseDto addMenu(@RequestBody MenuRequestDto dto) {
        return menuService.addMenu(dto);
    }

//    @PatchMapping("/update")
//    public MenuResponseDto updateMenu(@RequestBody MenuRequestDto dto) {
//        return menuService.updateMenu(dto);
//    }


    @GetMapping("/all")
    public List<MenuResponseDto> getAllMenus() {
        return menuService.getAllMenus();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return "Menu deleted successfully";
    }
}
