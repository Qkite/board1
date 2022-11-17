package com.example.boardtest.board1.domain.dto;


import com.example.boardtest.board1.domain.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserRequestDto {
    private String userName;
    private String password;

    public User toEntity(){

        User user = User.builder()
                .userName(userName)
                .password(password)
                .build();
        return user;
    }
}
