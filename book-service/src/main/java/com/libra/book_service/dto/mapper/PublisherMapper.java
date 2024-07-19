package com.libra.book_service.dto.mapper;

import com.libra.book_service.dto.PublisherDTO;
import com.libra.book_service.entity.Publishers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherDTO toDto(Publishers publishers);
    Publishers toEntity(PublisherDTO publisherDTO);
}