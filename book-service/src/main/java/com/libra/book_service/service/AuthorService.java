package com.libra.book_service.service;

import com.libra.book_service.dto.AuthorDTO;
import com.libra.book_service.dto.mapper.AuthorMapper;
import com.libra.book_service.entity.Authors;
import com.libra.book_service.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public Page<AuthorDTO> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).map(authorMapper::toDto);
    }

    public AuthorDTO getAuthorById(Long id) {
        Authors authors = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return authorMapper.toDto(authors);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Authors authors = authorMapper.toEntity(authorDTO);
        authors = authorRepository.save(authors);
        return authorMapper.toDto(authors);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Authors authors = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authors.setName(authorDTO.getName());
        authors.setBio(authorDTO.getBio());
        authors = authorRepository.save(authors);
        return authorMapper.toDto(authors);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}