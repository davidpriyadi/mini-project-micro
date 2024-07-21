package com.libra.user_service.dto;

import com.libra.user_service.validation.constraint.EmailIsExist;
import com.libra.user_service.validation.constraint.IdentityNumberIsExist;
import com.libra.user_service.validation.constraint.PhoneNumberIsExist;
import com.libra.user_service.validation.constraint.UsernameIsExist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegistrationRequest {

    @NotNull
    @Email
    @EmailIsExist
    private String email;

    @NotNull
    @UsernameIsExist
    private String username;

    @NotNull
    @PhoneNumberIsExist
    @Pattern(regexp = "^[0-9]*$",message = "Phone number must be digit")
    private String phoneNumber;

    @NotNull
    private String password;
    @NotNull
    private String address;
    @NotNull
    @IdentityNumberIsExist
    private String identityNumber;
    private String typeIdentity;
}