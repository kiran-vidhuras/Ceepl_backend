package com.vidhuras.ceepl.repository;

import com.vidhuras.ceepl.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<HomeEntity, Long> {
    List<HomeEntity> findByStatus(String status);
}
