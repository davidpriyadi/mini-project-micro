package com.libra.user_service.service;

import com.libra.user_service.dto.AuthenticationRequestDto;
import com.libra.user_service.dto.TokenDto;
import com.libra.user_service.dto.UserRegistrationRequest;
import com.libra.user_service.entity.Users;
import com.libra.user_service.repository.UserRepository;
import com.libra.user_service.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public TokenDto generateToken(AuthenticationRequestDto requestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken
                            (requestDto.getUsername(), requestDto.getPassword())
            );
            return TokenDto
                    .builder()
                    .username(requestDto.getUsername())
                    .token(jwtService.generateToken(requestDto.getUsername()))
                    .build();

        } catch (UsernameNotFoundException | BadCredentialsException e) {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }


    public void signup(UserRegistrationRequest request) {
        Users user = Users.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .address(request.getAddress())
                .identityNumber(request.getIdentityNumber())
                .typeIdentity(request.getTypeIdentity())
                .build();
        userRepository.save(user);
    }
}
