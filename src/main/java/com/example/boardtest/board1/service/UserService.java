package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findById(long id) throws JsonProcessingException {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        List<User> userList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(userList);

        return jsonData;
    }


}
