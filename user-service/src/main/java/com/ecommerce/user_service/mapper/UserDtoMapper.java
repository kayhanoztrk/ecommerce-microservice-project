package com.ecommerce.user_service.mapper;

import com.ecommerce.user_service.dto.request.UserCreateRequest;
import com.ecommerce.user_service.dto.response.UserResponseDto;
import com.ecommerce.user_service.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Component
public class UserDtoMapper {

    public User convertReqToEntity(UserCreateRequest userCreateRequest){
        User user = new User();
        user.setName(userCreateRequest.getName());
        return user;
    }
    public UserResponseDto convertEntityToResponse(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
}
