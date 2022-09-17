package com.gildedrose.quality.agecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NotOutdatedTest {

    private final NotOutdated notOutdated = new NotOutdated();

    @Test
    void check_whenAgeSmallerThanZero_shouldReturnFalse() {
        boolean isOutdated = notOutdated.check(-1);
        assertFalse(isOutdated);
    }

    @Test
    void check_whenAgeZero_shouldReturnTrue() {
        boolean isOutdated = notOutdated.check(0);
        assertTrue(isOutdated);
    }

    @Test
    void check_whenAgeGreaterThanZero_shouldReturnTrue() {
        boolean isOutdated = notOutdated.check(1);
        assertTrue(isOutdated);
    }

}
