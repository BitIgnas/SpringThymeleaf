package com.example.thymeleaf.configuration;

import com.example.thymeleaf.model.User;
import com.example.thymeleaf.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(
                    Arrays.asList(
                            new User("John", "john@email.com", 5),
                            new User("Peter", "peter@email.com", 3),
                            new User("Will", "will@email.com", 8),
                            new User("Marcus", "marcus@email.com", 1)
                    ));
        };
    }
}
