package com.example.boardtest.board1.repository;

import com.example.boardtest.board1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
