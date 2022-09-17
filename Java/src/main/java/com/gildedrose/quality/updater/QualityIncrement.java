package com.gildedrose.quality.updater;

import com.gildedrose.Item;

public class QualityIncrement implements QualityUpdater {

    private static final int MAX_QUALITY_POSSIBLE = 50;
    private final int incrementValue;

    public QualityIncrement(int incrementValue) {
        this.incrementValue = incrementValue;
    }

    @Override
    public void update(Item item) {
        item.quality = Math.min(MAX_QUALITY_POSSIBLE, item.quality + incrementValue);
    }
}
