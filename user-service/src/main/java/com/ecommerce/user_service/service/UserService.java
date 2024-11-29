package com.ecommerce.user_service.service;

import com.ecommerce.user_service.dto.request.UserCreateRequest;
import com.ecommerce.user_service.dto.response.UserResponseDto;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface UserService {
    List<UserResponseDto> findAll();
    UserResponseDto create(UserCreateRequest user);

    UserResponseDto findById(Long id);
}
