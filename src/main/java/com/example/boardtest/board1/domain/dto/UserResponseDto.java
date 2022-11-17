package com.example.boardtest.board1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userName;
    private String password;

// Builder를 사용하려면 NoArg~와 AllArg 모두 있어야 함
}
