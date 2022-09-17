package com.gildedrose.quality;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class BrieStrategyTest {

    private final BrieStrategy updater = new BrieStrategy();

    @Test
    void update_whenNotOutdated_shouldIncrementQualityByOne() {
        Item item = new Item("Test", 1, 2);

        updater.update(item);

        assertEquals(3, item.quality);
    }

    @Test
    void update_whenOutdated_shouldIncrementQualityByTwo() {
        Item item = new Item("Test", -1, 2);

        updater.update(item);

        assertEquals(4, item.quality);
    }
}
