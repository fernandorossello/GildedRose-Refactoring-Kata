package com.gildedrose.quality;

import com.gildedrose.Item;

public class NoOpQualityStrategy implements QualityStrategy{

    @Override
    public void update(Item item) {
        // Does nothing
    }
}
