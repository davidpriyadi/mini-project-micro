package com.libra.user_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationRequest {
    private String email;
    private String username;
    private String phoneNumber;
    private String password;
    private String address;
    private String identityNumber;
    private String typeIdentity;
}