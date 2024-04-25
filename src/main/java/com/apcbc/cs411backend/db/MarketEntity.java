package com.apcbc.cs411backend.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Markets")
public record MarketEntity(
        @Id Long marketID,
        @Column String marketName,
        @Column String marketLocation,
        @Column String productName,
        @Column Double productPrice
) {
}
