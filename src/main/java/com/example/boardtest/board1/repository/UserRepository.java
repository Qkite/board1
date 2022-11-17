package com.example.boardtest.board1.repository;

import com.example.boardtest.board1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUserName(String name);
}
