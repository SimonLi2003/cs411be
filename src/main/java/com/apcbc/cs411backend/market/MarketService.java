package com.apcbc.cs411backend.market;

import com.apcbc.cs411backend.db.MarketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {
    private final MarketRepository marketRepository;
    long globalID = 1000L;

    @Autowired
    public MarketService(MarketRepository marketRepository) {this.marketRepository = marketRepository;}

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @Transactional
    public void addNewMarket(String marketName, String marketLocation) {
        if (marketName == null || marketName.isEmpty()) {
            throw new IllegalArgumentException("market name cannot be null / empty");
        }

        if (marketLocation == null || marketLocation.isEmpty()) {
            throw new IllegalArgumentException("market location cannot be null / empty");
        }

        marketRepository.insert(globalID++, marketName, marketLocation);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    public List<MarketEntity> getAllMarkets() {
        return marketRepository.getAllMarkets();
    }

    public MarketEntity getMarketWithID(Long marketID) {
        Optional<MarketEntity> optionalMarket = marketRepository.getMarketEntityWithMarketID(marketID);
        if (optionalMarket.isEmpty()) {throw new IllegalArgumentException("market id does not exist");}
        return optionalMarket.get();
    }

    public String getMarketNameWithID(Long marketID) {
        MarketEntity marketEntity = getMarketWithID(marketID);
        return marketEntity.marketName();
    }

    public String getMarketLocationWithID(Long marketID) {
        MarketEntity marketEntity = getMarketWithID(marketID);
        return marketEntity.marketLocation();
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @Transactional
    public void updateMarketNameWithID(Long marketID, String marketName) {
        if (marketName == null || marketName.isEmpty()) {
            throw new IllegalArgumentException("market name cannot be null / empty");
        }

        Optional<MarketEntity> optionalMarket = marketRepository.getMarketEntityWithMarketID(marketID);
        if (optionalMarket.isEmpty()) {throw new IllegalArgumentException("market id does not exist");}

        MarketEntity market = optionalMarket.get();
        if (market.marketName() != null && market.marketName().equals(marketName)) {
            return;
        }

        marketRepository.updateMarketNameWithID(marketID, marketName);
    }

    @Transactional
    public void updateMarketLocationWithID(Long marketID, String marketLocation) {
        if (marketLocation == null || marketLocation.isEmpty()) {
            throw new IllegalArgumentException("market location cannot be null / empty");
        }

        Optional<MarketEntity> optionalMarket = marketRepository.getMarketEntityWithMarketID(marketID);
        if (optionalMarket.isEmpty()) {throw new IllegalArgumentException("market id does not exist");}

        MarketEntity market = optionalMarket.get();
        if (market.marketLocation() != null && market.marketLocation().equals(marketLocation)) {
            return;
        }

        marketRepository.updateMarketLocationWithID(marketID, marketLocation);
    }

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @Transactional
    public void deleteMarketWithID(Long marketID) {
        marketRepository.deleteMarketEntityWithID(marketID);
    }
}
