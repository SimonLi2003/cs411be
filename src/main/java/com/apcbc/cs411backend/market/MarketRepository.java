package com.apcbc.cs411backend.market;

import com.apcbc.cs411backend.db.MarketEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends ListCrudRepository<MarketEntity, Long> {
    @Query("SELECT * FROM Markets")
    List<MarketEntity> getAllMarkets();

    @Query("SELECT * FROM Markets WHERE market_id = :marketID")
    Optional<MarketEntity> getMarketEntityWithMarketID(Long marketID);

    @Query("INSERT INTO Markets(market_id, market_name, market_location) VALUES (:marketID, :marketName, :marketLocation)")
    void insert(Long marketID, String marketName, String marketLocation);

    @Modifying
    @Query("UPDATE Markets SET market_name = :marketName WHERE market_id = :marketID")
    void updateMarketNameWithID(Long marketID, String marketName);

    @Modifying
    @Query("UPDATE Markets SET market_location = :marketLocation WHERE market_id = :marketID")
    void updateMarketLocationWithID(Long marketID, String marketLocation);

    @Modifying
    @Query("DELETE FROM Markets WHERE market_id = :marketID")
    void deleteMarketEntityWithID(Long marketID);
}
