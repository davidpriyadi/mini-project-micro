package com.libra.loans_service.client.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String phoneNumber;
    private String address;
    private String identityNumber;
    private String typeIdentity;
}