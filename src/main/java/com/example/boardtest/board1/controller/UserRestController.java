package com.example.boardtest.board1.controller;


import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserRequestDto;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
import com.example.boardtest.board1.repository.UserRepository;
import com.example.boardtest.board1.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserRestController {

    private final UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) throws JsonProcessingException {

        User user = userService.findById(id);
        log.info(user.toString());

       return ResponseEntity.ok().body(user);

    }

    @PostMapping("/write")
    public String addUser(@RequestBody UserRequestDto userRequestDto){

        log.info(userRequestDto.toString());
        User user = userRequestDto.toEntity();
        String info = userService.saveUser(user);

        return info;



    }
}
