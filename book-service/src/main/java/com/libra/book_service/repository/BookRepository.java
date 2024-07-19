package com.libra.book_service.repository;

import com.libra.book_service.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Books, Long>, JpaSpecificationExecutor<Books> {
}