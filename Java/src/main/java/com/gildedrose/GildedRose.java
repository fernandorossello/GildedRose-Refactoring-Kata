package com.gildedrose;

import com.gildedrose.quality.QualityStrategy;
import com.gildedrose.quality.QualityStrategyFactory;
import com.gildedrose.sellin.SellStrategy;
import com.gildedrose.sellin.SellStrategyFactory;

class GildedRose {

    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        QualityStrategy qualityStrategy = QualityStrategyFactory.get(item);
        qualityStrategy.update(item);
    }

    private void updateSellIn(Item item) {
        SellStrategy sellStrategy = SellStrategyFactory.getStrategy(item);
        sellStrategy.update(item);
    }
}
