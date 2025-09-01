package com.vidhuras.ceepl.service;

import com.vidhuras.ceepl.dto.ContactRequestDto;
import com.vidhuras.ceepl.dto.ContactResponseDto;

public interface ContactService {
    ContactResponseDto saveContact(ContactRequestDto request);

    ContactResponseDto saveQuote(ContactRequestDto request);
}
