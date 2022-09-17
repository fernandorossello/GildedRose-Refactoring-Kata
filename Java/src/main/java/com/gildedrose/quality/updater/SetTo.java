package com.gildedrose.quality.updater;

import com.gildedrose.Item;

public class SetTo implements QualityUpdater {

    private final int quality;

    public SetTo(int quality) {
        this.quality = quality;
    }

    @Override
    public void update(Item item) {
        item.quality = quality;
    }
}
