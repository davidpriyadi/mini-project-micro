package com.libra.book_service.dto;

import lombok.Data;

@Data
public class BookFilterDTO {
    private String title;
    private String isbn;
    private Integer year;
    private String status;
}