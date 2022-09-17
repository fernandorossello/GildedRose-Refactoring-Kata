package com.gildedrose.quality.agecalculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OutdatedTest {

    private final Outdated outdated = new Outdated();

    @Test
    void check_whenAgeSmallerThanZero_shouldReturnTrue() {
        boolean isOutdated = outdated.check(-1);
        assertTrue(isOutdated);
    }

    @Test
    void check_whenAgeZero_shouldReturnFalse() {
        boolean isOutdated = outdated.check(0);
        assertFalse(isOutdated);
    }

    @Test
    void check_whenAgeGreaterThanZero_shouldReturnFalse() {
        boolean isOutdated = outdated.check(1);
        assertFalse(isOutdated);
    }
}
