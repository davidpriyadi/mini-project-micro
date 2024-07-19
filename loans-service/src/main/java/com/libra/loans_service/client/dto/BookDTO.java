package com.libra.loans_service.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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