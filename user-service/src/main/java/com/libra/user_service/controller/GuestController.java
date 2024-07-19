package com.libra.user_service.controller;

import com.libra.user_service.dto.AuthenticationRequestDto;
import com.libra.user_service.dto.TokenDto;
import com.libra.user_service.dto.UserRegistrationRequest;
import com.libra.user_service.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
@Validated
public class GuestController {

    private final GuestService guestService;


    @PostMapping("/sign")
    public ResponseEntity<TokenDto> authentication(@Validated @RequestBody AuthenticationRequestDto requestDto) {
        return new ResponseEntity<>(guestService.generateToken(requestDto), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Validated UserRegistrationRequest requestDto) {
        guestService.signup(requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}