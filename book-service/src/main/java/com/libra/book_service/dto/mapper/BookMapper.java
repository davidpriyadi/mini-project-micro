package com.libra.book_service.dto.mapper;

import com.libra.book_service.dto.BookDTO;
import com.libra.book_service.entity.Books;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, PublisherMapper.class})
public interface BookMapper {
    @Mapping(source = "authors", target = "author")
    @Mapping(source = "publishers", target = "publisher")
    BookDTO toDto(Books books);

    @Mapping(source = "author", target = "authors")
    @Mapping(source = "publisher", target = "publishers")
    Books toEntity(BookDTO bookDTO);
}