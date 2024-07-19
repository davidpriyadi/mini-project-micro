package com.libra.user_service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {
    @NotEmpty
//    @UniqueUsername
    private String username;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String division;
}
