package com.vidhuras.ceepl.repository;

import com.vidhuras.ceepl.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
