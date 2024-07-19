package com.libra.user_service.service;

import com.libra.user_service.dto.UserDTO;
import com.libra.user_service.dto.mapper.UserMapper;
import com.libra.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserDTO getUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        return userMapper.toUserDTO(user);
    }
}