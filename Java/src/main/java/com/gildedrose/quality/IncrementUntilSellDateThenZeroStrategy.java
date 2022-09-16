package com.gildedrose.quality;

import com.gildedrose.Item;

public class IncrementUntilSellDateThenZeroStrategy implements
    QualityStrategy {


    @Override
    public void update(Item item) {
        if(item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality++;
        }
    }
}
