package com.libra.loans_service.client;

import com.libra.loans_service.client.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserClient {

    private final RestTemplate restTemplate;

    @Value("${sevice.user.url.base}")
    private String userServiceUrl;


    public UserDTO getUserById(Long id) {
        return restTemplate.getForObject(userServiceUrl + id, UserDTO.class);
    }
}
