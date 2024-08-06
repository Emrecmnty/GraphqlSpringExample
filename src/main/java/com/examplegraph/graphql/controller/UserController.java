package com.examplegraph.graphql.controller;

import com.examplegraph.graphql.model.User;
import com.examplegraph.graphql.model.UserRequest;
import com.examplegraph.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @QueryMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    User getUserById(@Argument final Long id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    User createUser(@Argument final UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @MutationMapping
    User updateUser(@Argument final UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    Boolean deleteUser(@Argument final Long id) {
        userService.deleteUser(id);
        return true;
    }

}
