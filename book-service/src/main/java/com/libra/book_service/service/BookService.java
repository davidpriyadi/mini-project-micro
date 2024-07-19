package com.libra.book_service.service;

import com.libra.book_service.dto.BookDTO;
import com.libra.book_service.dto.mapper.BookMapper;
import com.libra.book_service.entity.Books;
import com.libra.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Books books = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
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