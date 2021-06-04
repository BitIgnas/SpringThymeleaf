package com.example.thymeleaf.service;

import com.example.thymeleaf.model.User;
import com.example.thymeleaf.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();

    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void updateUserById(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {

      User userToUpdate = userRepository.getById(user.getId());
      user.setName(user.getName());
      user.setEmail(user.getEmail());
      user.setExperience(user.getExperience());

      userRepository.save(userToUpdate);
     }
}
