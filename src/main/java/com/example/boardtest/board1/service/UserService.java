package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public String returnToJson(User user) throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(userList);

        return jsonData;
    }


}
