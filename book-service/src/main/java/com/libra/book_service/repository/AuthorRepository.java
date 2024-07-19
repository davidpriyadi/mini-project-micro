package com.libra.book_service.repository;

import com.libra.book_service.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
}