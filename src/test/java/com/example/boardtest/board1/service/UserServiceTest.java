package com.example.boardtest.board1.service;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
import com.example.boardtest.board1.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        String[] messages1 = userService.saveUser(user1);

        assertEquals(messages1[0], user1.getUserName());
        assertEquals(messages1[1], "아이디 " + user1.getUserName() + "가 생성되었습니다." );

    }

    @Test
    @DisplayName("중복된 아이디를 생성하지 않는지 확인")
    void addTest2(){
        
        User user2 = new User("안녕히히", "123456");
        Mockito.when(userRepository.save(user2))
                .thenReturn(user2);


        String[] messages2 = userService.saveUser(user2);

        assertEquals(messages2[0], user2.getUserName());
        assertEquals(messages2[1], "아이디가 중복됩니다. 다른 아이디를 입력해주세요." );
        // DB에 의존 되지 않아 들어있는 정보인지 확인할 수 없는 상태라서 그런지?


    }

}