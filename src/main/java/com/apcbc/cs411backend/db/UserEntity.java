package com.apcbc.cs411backend.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Users")
public record UserEntity(
        @Id Long userID,
        @Column String userEmail,
        @Column String userName,
        @Column String password
) {
}