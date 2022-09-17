package com.gildedrose.quality;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegularDecreaseStrategyTest {

    private RegularDecreaseStrategy updater;

    @BeforeEach
    void setUp() {
        updater = new RegularDecreaseStrategy();
    }

    @Test
    void update_whenNoOutdated_shouldDecreaseQualityByOne() {
        Item item = new Item("Test", 1, 2);

        updater.update(item);

        assertEquals(1, item.quality);
    }

    @Test
    void update_whenOutdated_shouldDecreaseQualityByTwo() {
        Item item = new Item("Test", -1, 2);

        updater.update(item);

        assertEquals(0, item.quality);
    }

}
