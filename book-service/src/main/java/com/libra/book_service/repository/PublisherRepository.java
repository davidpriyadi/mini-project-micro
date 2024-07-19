package com.libra.book_service.repository;

import com.libra.book_service.entity.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publishers, Long> {
}