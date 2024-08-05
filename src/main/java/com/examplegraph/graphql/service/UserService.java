package com.examplegraph.graphql.service;

import com.examplegraph.graphql.model.User;
import com.examplegraph.graphql.model.UserRequest;
import com.examplegraph.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public User createUser(UserRequest userRequest) {
        User user =
                User.builder()
                        .username(userRequest.getUsername())
                        .password(userRequest.getPassword())
                        .role(userRequest.getRole())
                        .build();
        return userRepository.save(user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing = getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setPassword(userRequest.getPassword());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        User existing = getUserById(id);
        userRepository.delete(existing);
    }
}


