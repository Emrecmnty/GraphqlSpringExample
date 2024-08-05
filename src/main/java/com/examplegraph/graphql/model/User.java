package com.examplegraph.graphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "'user'")
public class User extends BaseEntity {

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
