package com.libra.book_service.service;

import com.libra.book_service.dto.BookDTO;
import com.libra.book_service.dto.BookFilterDTO;
import com.libra.book_service.dto.mapper.BookMapper;
import com.libra.book_service.entity.Books;
import com.libra.book_service.repository.BookRepository;
import com.libra.book_service.repository.specification.BookSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public Page<BookDTO> searchBooks(BookFilterDTO filter, Pageable pageable) {
        Specification<Books> spec = Specification.where(null);

        if (Objects.nonNull(filter.getTitle())) {
            spec = spec.and(BookSpecification.hasTitle(filter.getTitle()));
        }
        if (Objects.nonNull(filter.getIsbn())) {
            spec = spec.and(BookSpecification.hasIsbn(filter.getIsbn()));
        }
        if (Objects.nonNull(filter.getYear())) {
            spec = spec.and(BookSpecification.hasPublicationYear(filter.getYear()));
        }
        if (Objects.nonNull(filter.getStatus())) {
            spec = spec.and(BookSpecification.hasStatus(filter.getStatus()));
        }

        return bookRepository.findAll(spec, pageable).map(bookMapper::toDto);
    }

    public BookDTO getBookById(Long id) {
        Books books = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        return bookMapper.toDto(books);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Books books = bookMapper.toEntity(bookDTO);
        books = bookRepository.save(books);
        return bookMapper.toDto(books);
    }

//    public BookDTO updateBook(Long id, BookDTO bookDTO) {
//        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
//        book.setTitle(bookDTO.getTitle());
//        book.setIsbn(bookDTO.getIsbn());
//        book.setPublicationYear(bookDTO.getPublicationYear());
//        book.setStatus(bookDTO.getStatus());
//        book.setQrCode(bookDTO.getQrCode());
//        book.setAuthor(bookMapper.toEntity(bookDTO.getAuthor()));
//        book.setPublisher(bookMapper.toEntity(bookDTO.getPublisher()));
//        book = bookRepository.save(book);
//        return bookMapper.toDto(book);
//    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}