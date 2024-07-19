package com.libra.book_service.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {
    private Long id;
    private String name;
    private String address;
}