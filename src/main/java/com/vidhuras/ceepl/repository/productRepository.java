package com.vidhuras.ceepl.repository;

import com.vidhuras.ceepl.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface productRepository extends JpaRepository<product, Long> {

}
