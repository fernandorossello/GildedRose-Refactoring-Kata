package com.gildedrose.quality.agecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetweenTest {

    public static final int LOWER_LIMIT = 5;
    public static final int HIGHER_LIMIT = 10;
    Between between = new Between(LOWER_LIMIT, HIGHER_LIMIT);

    @Test
    void check_lowerLimitInclusiveness_shouldReturnTrue() {
        boolean isBetween = between.check(LOWER_LIMIT);

        assertTrue(isBetween);
    }

    @Test
    void check_higherLimitInclusiveness_shouldReturnTrue() {

        boolean isBetween = between.check(HIGHER_LIMIT);
        assertTrue(isBetween);
    }

    @Test
    void check_anyNumberBetweenTheLimits_shouldReturnTrue() {
        for (int i = LOWER_LIMIT; i <= HIGHER_LIMIT; i++) {
            boolean isBetween = between.check(HIGHER_LIMIT);
            assertTrue(isBetween);
        }
    }

    @Test
    void check_aHigherNumberThanHigherLimit_shouldReturnFalse() {
        boolean isBetween = between.check(HIGHER_LIMIT + 1);
        assertFalse(isBetween);
    }

    @Test
    void check_aLowerNumberThanLowerLimit_shouldReturnFalse() {
        boolean isBetween = between.check(LOWER_LIMIT - 1);
        assertFalse(isBetween);
    }

}
