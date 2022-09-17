package com.gildedrose.quality.agecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GreaterThanTest {

    private static final int LIMIT = 5;
    private final GreaterThan greater = new GreaterThan(LIMIT);

    @Test
    void check_aHigherNumberThanLimit_shouldReturnTrue() {
        boolean isGreater = greater.check(LIMIT + 1);
        assertTrue(isGreater);
    }

    @Test
    void check_aLowerNumberThanLimit_shouldReturnFalse() {
        boolean isGreater = greater.check(LIMIT - 1);
        assertFalse(isGreater);
    }

    @Test
    void check_sameNumberAsLimit_shouldReturnFalse() {
        boolean isGreater = greater.check(LIMIT);
        assertFalse(isGreater);
    }
}
