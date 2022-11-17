package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
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

    public User findById(long id) throws JsonProcessingException {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();

        return user;
    }



    public String[] saveUser(User user){
        Optional<User> find = userRepository.findByUserName(user.getUserName());

        if(find.isEmpty()){
            userRepository.save(user);

            return new String[]{user.getUserName(), "아이디 " + user.getUserName() + "가 생성되었습니다." };
        } else{
            return new String[]{user.getUserName(), "아이디가 중복됩니다. 다른 아이디를 입력해주세요." };
        }

    }



}
