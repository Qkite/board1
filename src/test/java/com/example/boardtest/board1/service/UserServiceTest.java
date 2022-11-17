package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserRequestDto;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
import com.example.boardtest.board1.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    // Mockito를 이용해서 가짜 객체를 주입해줌

    private UserService userService;

    @BeforeEach
    void setup(){
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("회원 등록이 잘 되는지 확인")
    void addTest1(){
        User user1 = new User("동해물과 백두산이", "123456");
        Mockito.when(userRepository.save(user1))
                .thenReturn(user1);

        String message = userService.saveUser(user1);

        assertEquals(message, "아이디 " + user1.getUserName() + "가 생성되었습니다." );

    }

    @Test
    @DisplayName("중복된 정보를 찾는지 확인")
    void addTest2(){

        User user = new User(2,"안녕히히", "123456");


        Mockito.when(userRepository.findByUserName(user.getUserName()))
                .thenReturn(Optional.of(user));

        Boolean isEmpty = userService.messaging(user);

        assertFalse(isEmpty);

    }

}