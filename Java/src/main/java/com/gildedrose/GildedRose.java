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

            QualityStrategy qualityStrategy = QualityStrategyFactory.get(item);

            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                qualityStrategy.update(item);

            } else {
                if (canIncreaseQuality(item)) {
                    incrementQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            incrementQualityIfPossible(item);

                            if (item.sellIn < 6) {
                                incrementQualityIfPossible(item);
                            }
                        }
                    }
                }
            }

            // Backstage
            // GreaterThan 10 -> +1
            // Between [6,10] -> +2
            // Between [5,1]  -> +3
            // SmallerThan 0  -> = 0

            // Aged Brie
            // GreaterThan 0 -> +1
            // SmallerThan 1 -> +2

            // Regular objects
            // SmallerThan 0 -> -2

            // Sulfuras
            // Never decreases anything

            // Quality between (0-50)

            SellStrategy sellStrategy = SellStrategyFactory.getStrategy(item);
            sellStrategy.update(item);

            if (isOutdated(item)) {
                if (item.name.equals("Aged Brie")) {
                    incrementQualityIfPossible(item);
                } else {
                    qualityStrategy.update(item);
                }
            }
        }
    }

    private void incrementQualityIfPossible(Item item) {
        if (canIncreaseQuality(item)) {
            incrementQuality(item);
        }
    }

    private boolean isOutdated(Item item) {
        return item.sellIn < 0;
    }

    private void incrementQuality(Item item) {
        item.quality++;
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }
}
