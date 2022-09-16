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

            SellStrategy sellStrategy = SellStrategyFactory.getStrategy(item);
            sellStrategy.update(item);

            if (isOutdated(item)) {
                if (item.name.equals("Aged Brie")) {
                    incrementQualityIfPossible(item);
                } else {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        qualityStrategy.update(item);
                    } else {
                        item.quality = 0;
                    }
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
