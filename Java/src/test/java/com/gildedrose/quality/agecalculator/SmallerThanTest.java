package com.gildedrose.quality.agecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SmallerThanTest {

    private static final int LIMIT = 5;
    private final SmallerThan smaller = new SmallerThan(LIMIT);

    @Test
    void check_aNumberSmallerThanTheLimit_shouldReturnTrue() {
        boolean isSmaller = smaller.check(LIMIT - 1);
        assertTrue(isSmaller);
    }

    @Test
    void check_aNumberGreaterThanTheLimit_shouldReturnFalse() {
        boolean isSmaller = smaller.check(LIMIT + 1);
        assertFalse(isSmaller);
    }

    @Test
    void check_aNumberEqualToTheLimit_shouldReturnFalse() {
        boolean isSmaller = smaller.check(LIMIT);
        assertFalse(isSmaller);
    }

}
