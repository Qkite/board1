package com.example.boardtest.board1.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password; // DB에는 존재해야하지만, 사용자에게 공개하면 안됨

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
