package com.libra.book_service.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private String status;
    private String qrCode;
    private AuthorDTO author;
    private PublisherDTO publisher;
}