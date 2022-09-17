package com.gildedrose.quality.updater;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QualityIncreaseTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Test", 2, 2);
    }

    @Test
    void update_whenIncreasingShouldIncreaseQualityInTheGivenValue() {
        QualityIncrement incrementer = new QualityIncrement(3);

        incrementer.update(item);

        assertEquals(5, item.quality);
    }

    @Test
    void update_shouldNotIncreaseGreaterThanTheMaxValue() {
        QualityIncrement incrementer = new QualityIncrement(50);

        incrementer.update(item);

        assertEquals(50, item.quality);
    }

}
