package com.vidhuras.ceepl.repository;

import com.vidhuras.ceepl.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
}