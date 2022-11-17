package com.example.boardtest.board1.controller;


import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.repository.UserRepository;
import com.example.boardtest.board1.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserRepository userRepository;

    private final UserService userService;

    public UserRestController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String getUser(@PathVariable long id) throws JsonProcessingException {
       Optional<User> userOptional = userRepository.findById(id);
       User user = userOptional.get();
       return userService.returnToJson(user);

    }
}
