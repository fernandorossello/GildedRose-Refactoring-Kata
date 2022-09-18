package com.gildedrose.sellin;

import com.gildedrose.Item;

public class SellStrategyFactory {

    public static SellStrategy getStrategy(Item item) {

        if (item.name.startsWith("Sulfuras")) {
            return new NoOpSellStrategy();
        }

        return new ReduceSellInStrategy();
    }
}
