package com.vidhuras.ceepl.repository;

import com.vidhuras.ceepl.entity.HomeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeServiceRepository extends JpaRepository<HomeService, Long> {
}
