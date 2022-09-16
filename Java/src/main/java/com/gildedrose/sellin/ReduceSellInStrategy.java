package com.gildedrose.sellin;

import com.gildedrose.Item;

public class ReduceSellInStrategy implements SellStrategy{

    @Override
    public void update(Item item) {
        item.sellIn--;
    }
}
