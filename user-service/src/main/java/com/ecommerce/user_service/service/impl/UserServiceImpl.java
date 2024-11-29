package com.ecommerce.user_service.service.impl;

import com.ecommerce.user_service.dto.request.UserCreateRequest;
import com.ecommerce.user_service.dto.response.UserResponseDto;
import com.ecommerce.user_service.exception.UserNotFoundException;
import com.ecommerce.user_service.mapper.UserDtoMapper;
import com.ecommerce.user_service.model.User;
import com.ecommerce.user_service.repository.UserRepository;
import com.ecommerce.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public UserServiceImpl(UserRepository userRepository, UserDtoMapper userDtoMapper) {
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public List<UserResponseDto> findAll() {

        List<UserResponseDto> userResponseDtoList =  userRepository.findAll()
                .stream()
                .map(user -> userDtoMapper.convertEntityToResponse(user))
                .collect(Collectors.toList());
        logger.info("finding allUserList {}", userResponseDtoList);
        return userResponseDtoList;
    }

    @Override
    public UserResponseDto create(UserCreateRequest userCreateRequest) {
        User user = userDtoMapper.convertReqToEntity(userCreateRequest);
        User savedUser = userRepository.save(user);
        return userDtoMapper.convertEntityToResponse(savedUser);
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id + " user not found!"));

        return userDtoMapper.convertEntityToResponse(user);
    }
}
