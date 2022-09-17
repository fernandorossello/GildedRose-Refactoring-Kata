package com.gildedrose.quality.updater;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QualityDecrementTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Test", 2, 5);
    }

    @Test
    void update_whenIncreasingShouldDecrementQualityInTheGivenValue() {
        QualityDecrement decrement = new QualityDecrement(2);

        decrement.update(item);

        assertEquals(3, item.quality);
    }

    @Test
    void update_shouldNotIncreaseLowerThanTheMinValue() {
        QualityDecrement decrement = new QualityDecrement(50);

        decrement.update(item);

        assertEquals(0, item.quality);
    }

}
