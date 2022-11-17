package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
import com.example.boardtest.board1.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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



    public String saveUser(User user){

        boolean isEmpty = messaging(user);

        if (isEmpty){
            userRepository.save(user);
            return "아이디 " + user.getUserName()+ "가 생성되었습니다.";
        } else{
            return "아이디가 중복됩니다. 다른 아이디를 입력해주세요.";
        }

    }
    
    // 테스트를 위해서 메시지를 보내는 부분과 계정정보를 저장하는 부분을 분리
    public boolean messaging(User user){
        Optional<User> find = userRepository.findByUserName(user.getUserName());

        if(find.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

}
