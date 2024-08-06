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

    public User getUserById(final Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public User createUser(final UserRequest userRequest) {
        final User user =
                User.builder()
                        .username(userRequest.getUsername())
                        .password(userRequest.getPassword())
                        .role(userRequest.getRole())
                        .build();
        return userRepository.save(user);
    }

    public User updateUser(final UserRequest userRequest) {
        final User existing = getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setPassword(userRequest.getPassword());
        return userRepository.save(existing);
    }

    public void deleteUser(final Long id) {
        final User existing = getUserById(id);
        userRepository.delete(existing);
    }
}


