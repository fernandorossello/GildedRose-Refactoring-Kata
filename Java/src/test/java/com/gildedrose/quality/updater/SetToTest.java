package com.gildedrose.quality.updater;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

class SetToTest {

    @Test
    void update_shouldSetItemQualityToGivenValue() {
        Item item = new Item("Test", 2, 5);
        int expectedQuality = 0;

        SetTo updater = new SetTo(expectedQuality);
        updater.update(item);

        assertEquals(expectedQuality, item.quality);
    }

}
