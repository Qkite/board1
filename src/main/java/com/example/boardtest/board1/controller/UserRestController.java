package com.example.boardtest.board1.controller;


import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.repository.UserRepository;
import com.example.boardtest.board1.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserRepository userRepository, UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable long id) throws JsonProcessingException {

       return userService.findById(id);

    }
}
