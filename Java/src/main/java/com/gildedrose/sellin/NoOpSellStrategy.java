package com.gildedrose.sellin;

import com.gildedrose.Item;

public class NoOpSellStrategy implements SellStrategy {

    @Override
    public void update(Item item) {
        // Does nothing
    }
}
