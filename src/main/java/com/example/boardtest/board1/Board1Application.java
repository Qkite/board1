package com.example.boardtest.board1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Board1Application {

	public static void main(String[] args) {
		SpringApplication.run(Board1Application.class, args);
	}

}
