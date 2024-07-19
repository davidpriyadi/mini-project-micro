package com.libra.user_service.dto.mapper;

import com.libra.user_service.dto.UserDTO;
import com.libra.user_service.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(Users user);
}