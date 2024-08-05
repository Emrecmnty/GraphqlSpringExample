package com.examplegraph.graphql.model;
import lombok.Data;

@Data
public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private Role role;

}
