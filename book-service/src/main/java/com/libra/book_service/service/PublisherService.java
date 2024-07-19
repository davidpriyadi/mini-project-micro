package com.libra.book_service.service;

import com.libra.book_service.dto.PublisherDTO;
import com.libra.book_service.dto.mapper.PublisherMapper;
import com.libra.book_service.entity.Publishers;
import com.libra.book_service.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    public Page<PublisherDTO> getAllPublishers(Pageable pageable) {
        return publisherRepository.findAll(pageable).map(publisherMapper::toDto);
    }

    public PublisherDTO getPublisherById(Long id) {
        Publishers publishers = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        return publisherMapper.toDto(publishers);
    }

    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publishers publishers = publisherMapper.toEntity(publisherDTO);
        publishers = publisherRepository.save(publishers);
        return publisherMapper.toDto(publishers);
    }

    public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO) {
        Publishers publishers = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        publishers.setName(publisherDTO.getName());
        publishers.setAddress(publisherDTO.getAddress());
        publishers = publisherRepository.save(publishers);
        return publisherMapper.toDto(publishers);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}