package com.gildedrose.quality;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IncrementUntilSellDateThenZeroStrategyTest {

    private IncrementUntilSellDateThenZeroStrategy updater;

    @BeforeEach
    void setUp() {
        this.updater = new IncrementUntilSellDateThenZeroStrategy();
    }

    @Test
    void update_whenItemNotOutdated_shouldIncrementQuality() {
        Item item = new Item("Test", 1, 2);

        updater.update(item);

        assertEquals(3, item.quality);
    }

    @Test
    void update_whenItemOutdated_shouldSetQualityToZero() {
        Item item = new Item("Test", -1, 9);

        updater.update(item);

        assertEquals(0, item.quality);
    }

}
