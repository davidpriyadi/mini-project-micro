package com.libra.loans_service.client;

import com.libra.loans_service.client.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookClient {


    @Value("${service.book.url.base}")
    private String bookServiceUrl;



    private final RestTemplate restTemplate;

    public BookDTO getBookById(Long bookId) {
        return restTemplate.getForObject(bookServiceUrl + bookId, BookDTO.class);
    }
}
