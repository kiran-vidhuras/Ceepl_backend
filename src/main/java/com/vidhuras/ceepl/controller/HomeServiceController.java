package com.vidhuras.ceepl.controller;

import com.vidhuras.ceepl.dto.*;

import com.vidhuras.ceepl.service.HomeServiceService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/home-services")
@RequiredArgsConstructor
public class HomeServiceController {

    private final HomeServiceService service;

    @PostMapping
    public HomeServiceResponse create(@RequestBody HomeServiceRequestDto requestDto, HttpServletRequest request) {
        return service.create(requestDto, "system", request.getRemoteAddr());
    }

    @GetMapping
    public List<HomeServiceResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HomeServiceResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public HomeServiceResponse update(@PathVariable Long id, @RequestBody HomeServiceRequestDto requestDto, HttpServletRequest request) {
        return service.update(id, requestDto, "system", request.getRemoteAddr());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


