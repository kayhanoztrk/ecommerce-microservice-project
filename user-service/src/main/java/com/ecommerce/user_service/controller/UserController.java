package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.dto.request.UserCreateRequest;
import com.ecommerce.user_service.dto.response.UserResponseDto;
import com.ecommerce.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        List<UserResponseDto> userResponseDtoList = userService.findAll();
        return ResponseEntity.ok(userResponseDtoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateRequest userCreateRequest){
        UserResponseDto userResponseDto = userService.create(userCreateRequest);
        return ResponseEntity.ok(userResponseDto);
    }
}
