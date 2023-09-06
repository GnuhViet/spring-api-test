package com.example.springapi;

import com.example.springapi.user.User;
import com.example.springapi.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository
	) {
		return args -> {
			userRepository.save(User.builder().fullName("admin").build());
			userRepository.save(User.builder().fullName("user1").build());
			userRepository.save(User.builder().fullName("user1").build());
			log.info("data initialize finished");
		};
	}
}
