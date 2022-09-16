package com.gildedrose.quality;

import com.gildedrose.Item;

public class RegularDecreaseStrategy implements QualityStrategy {

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality--;
            }
        }
    }
}
