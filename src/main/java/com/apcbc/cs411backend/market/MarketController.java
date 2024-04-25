package com.apcbc.cs411backend.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/market")
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {this.marketService = marketService;}

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
}
