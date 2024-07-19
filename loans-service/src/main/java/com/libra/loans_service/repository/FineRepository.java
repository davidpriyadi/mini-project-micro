package com.libra.loans_service.repository;

import com.libra.loans_service.entity.Fines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FineRepository extends JpaRepository<Fines, Long> {
    List<Fines> findByUserIdAndStatus(Long userId, Fines.FineStatus status);
}