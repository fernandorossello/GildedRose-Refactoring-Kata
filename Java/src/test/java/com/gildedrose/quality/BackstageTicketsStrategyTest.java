package com.gildedrose.quality;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BackstageTicketsStrategyTest {

    // Backstage
    // GreaterThan 10 -> +1
    // Between [6,10] -> +2
    // Between [5,0]  -> +3
    // SmallerThan 0  -> = 0

    private BackstageTicketsStrategy updater;

    @BeforeEach
    void setUp() {
        this.updater = new BackstageTicketsStrategy();
    }

    @Test
    void update_whenMoreThan10DaysPending_shouldIncrementQualityByOne() {
        Item item = new Item("Test", 11, 2);

        updater.update(item);

        assertEquals(3, item.quality);
    }

    @Test
    void update_when7DaysLeft_shouldIncrementQualityByTwo() {
        Item item = new Item("Test", 7, 3);

        updater.update(item);

        assertEquals(5, item.quality);
    }

    @Test
    void update_when2DaysLeft_shouldIncrementQualityByThree() {
        Item item = new Item("Test", 2, 3);

        updater.update(item);

        assertEquals(6, item.quality);
    }

    @Test
    void update_whenOutdated_shouldSetQualityToZero() {
        Item item = new Item("Test", -1, 3);

        updater.update(item);

        assertEquals(0, item.quality);
    }

}
