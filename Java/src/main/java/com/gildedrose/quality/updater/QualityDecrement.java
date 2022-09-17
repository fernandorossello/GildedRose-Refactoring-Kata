package com.gildedrose.quality.updater;

import com.gildedrose.Item;

public class QualityDecrement implements QualityUpdater {

    private static final int MIN_POSSIBLE_QUALITY = 0;
    private final int decrementValue;

    public QualityDecrement(int decrementValue) {
        this.decrementValue = decrementValue;
    }

    @Override
    public void update(Item item) {
        item.quality = Math.max(MIN_POSSIBLE_QUALITY, item.quality - decrementValue);
    }
}
