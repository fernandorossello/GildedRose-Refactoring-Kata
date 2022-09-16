package com.gildedrose.sellin;

import com.gildedrose.Item;

public class SellStrategyFactory {

    public static SellStrategy getStrategy(Item item) {

        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return new NoOpSellStrategy();
        }

        return new ReduceSellInStrategy();
    }
}
