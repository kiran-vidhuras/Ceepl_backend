package com.vidhuras.ceepl.repository;


import com.vidhuras.ceepl.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
