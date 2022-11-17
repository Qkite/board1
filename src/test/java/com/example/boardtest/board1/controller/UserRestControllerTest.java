package com.example.boardtest.board1.controller;

import com.example.boardtest.board1.domain.User;
import com.example.boardtest.board1.domain.dto.UserResponseDto;
import com.example.boardtest.board1.repository.UserRepository;
import com.example.boardtest.board1.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;


    @Test
    @DisplayName("id 조회가 제대로 이루어지는지 확인")
    void getTest() throws Exception {

        UserResponseDto userResponseDto = UserResponseDto.builder()
                .id(2L)
                .userName("안녕히히")
                .password("1234563")
                .build();

        given(userService.findById(2L)).willReturn(new User(2, "안녕히히", "1234563"));


        Long id = 2L;
        String url = String.format("/api/v1/users/%d", id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.userName").value("안녕히히"))
                .andExpect(jsonPath("$.password").value("1234563"));

        verify(userService).findById(id);

    }

//    @Test
//    @DisplayName("계정 생성이 제대로 이루어지는지 확인")
//    void addTest(){
//
//        User savedUser = new User("아이디", "패스워드");
//
//
//        given(userService.saveUser(savedUser))
//    }

}