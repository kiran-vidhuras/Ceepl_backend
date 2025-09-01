package com.vidhuras.ceepl.service.serviceImpl;

import com.vidhuras.ceepl.dto.ContactRequestDto;
import com.vidhuras.ceepl.dto.ContactResponseDto;
import com.vidhuras.ceepl.entity.Contact;
import com.vidhuras.ceepl.entity.Quote;
import com.vidhuras.ceepl.repository.ContactRepository;
import com.vidhuras.ceepl.repository.QuoteRepository;
import com.vidhuras.ceepl.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final QuoteRepository quoteRepository;
    private final JavaMailSender mailSender;

    public ContactServiceImpl(ContactRepository contactRepository, QuoteRepository quoteRepository, JavaMailSender mailSender) {
        this.contactRepository = contactRepository;
        this.quoteRepository = quoteRepository;
        this.mailSender = mailSender;
    }

    private void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public ContactResponseDto saveContact(ContactRequestDto request) {
        Contact contact = new Contact();
        contact.setFullName(request.getFullName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setState(request.getState());
        contact.setCountry(request.getCountry());
        contact.setMessage(request.getMessage());
        contact.setCreatedOn(LocalDateTime.now());
        contact.setStatus("NEW");

        contact = contactRepository.save(contact);

        // Send email
        String emailBody = buildEmailBody(contact);
        sendEmail("supraajjada55@gmail.com", "New Contact Submission", emailBody);

        return buildResponse(contact);
    }

    @Override
    public ContactResponseDto saveQuote(ContactRequestDto request) {
        Quote quote = new Quote();
        quote.setFullName(request.getFullName());
        quote.setEmail(request.getEmail());
        quote.setPhone(request.getPhone());
        quote.setMessage(request.getMessage());
        quote.setCreatedOn(LocalDateTime.now());
        quote.setStatus("QUOTE");

        quote = quoteRepository.save(quote);

        // Send email
        String emailBody = buildEmailBody(quote);
        sendEmail("supraajjada55@gmail.com", "New Quote Submission", emailBody);

        return buildResponseFromQuote(quote);
    }

    private String buildEmailBody(Contact contact) {
        return "Name: " + contact.getFullName() + "\n" +
                "Email: " + contact.getEmail() + "\n" +
                "Phone: " + contact.getPhone() + "\n" +
                "State: " + contact.getState() + "\n" +
                "District: " + contact.getCountry() + "\n" +
                "Message: " + contact.getMessage();
    }

    private String buildEmailBody(Quote quote) {
        return "Name: " + quote.getFullName() + "\n" +
                "Email: " + quote.getEmail() + "\n" +
                "Phone: " + quote.getPhone() + "\n" +
                "Message: " + quote.getMessage();
    }

    private ContactResponseDto buildResponse(Contact contact) {
        ContactResponseDto response = new ContactResponseDto();
        response.setId(contact.getId());
        response.setFullName(contact.getFullName());
        response.setEmail(contact.getEmail());
        response.setPhone(contact.getPhone());
        response.setMessage(contact.getMessage());
        response.setStatus(contact.getStatus());
        return response;
    }

    private ContactResponseDto buildResponseFromQuote(Quote quote) {
        ContactResponseDto response = new ContactResponseDto();
        response.setId(quote.getId());
        response.setFullName(quote.getFullName());
        response.setEmail(quote.getEmail());
        response.setPhone(quote.getPhone());
        response.setMessage(quote.getMessage());
        response.setStatus(quote.getStatus());
        return response;
    }
}
