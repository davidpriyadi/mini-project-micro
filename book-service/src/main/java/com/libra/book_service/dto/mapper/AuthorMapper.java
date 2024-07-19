package com.libra.book_service.dto.mapper;

import com.libra.book_service.dto.AuthorDTO;
import com.libra.book_service.entity.Authors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDto(Authors authors);
    Authors toEntity(AuthorDTO authorDTO);
}