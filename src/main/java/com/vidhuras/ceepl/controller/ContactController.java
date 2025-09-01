package com.vidhuras.ceepl.controller;


import com.vidhuras.ceepl.dto.ContactRequestDto;
import com.vidhuras.ceepl.dto.ContactResponseDto;
import com.vidhuras.ceepl.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/submit")
    public ResponseEntity<ContactResponseDto> submitContact(@RequestBody ContactRequestDto request) {
        ContactResponseDto response = contactService.saveContact(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/quote")
    public ResponseEntity<ContactResponseDto> submitQuote(@RequestBody ContactRequestDto request) {
        ContactResponseDto response = contactService.saveQuote(request);
        return ResponseEntity.ok(response);
    }
}
