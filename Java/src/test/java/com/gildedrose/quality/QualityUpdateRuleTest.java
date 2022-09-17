package com.gildedrose.quality;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.gildedrose.Item;
import com.gildedrose.quality.agecalculator.AgeCalculator;
import com.gildedrose.quality.updater.QualityUpdater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QualityUpdateRuleTest {

    private Item item;
    @Mock
    private AgeCalculator mockAgeCalculator;
    private FakeQualityUpdater fakeQualityUpdater;

    @BeforeEach
    void setUp() {
        item = new Item("Test", 2, 5);

        fakeQualityUpdater = new FakeQualityUpdater();
    }

    @Test
    void updateIfApplies_whenAgeCalculatorApplies_shouldExecuteQualityUpdater() {
        when(mockAgeCalculator.check(2)).thenReturn(true);
        QualityUpdateRule rule = new QualityUpdateRule(mockAgeCalculator, fakeQualityUpdater);

        rule.updateIfApplies(item);

        assertTrue(fakeQualityUpdater.applied);
    }

    @Test
    void updateIfApplies_whenAgeCalculatorDoesNotApplies_shouldNOTExecuteQualityUpdater() {
        when(mockAgeCalculator.check(2)).thenReturn(false);
        QualityUpdateRule rule = new QualityUpdateRule(mockAgeCalculator, fakeQualityUpdater);

        rule.updateIfApplies(item);

        assertFalse(fakeQualityUpdater.applied);
    }

    private static class FakeQualityUpdater implements QualityUpdater {

        public boolean applied = false;

        @Override
        public void update(Item item) {
            this.applied = true;
        }
    }

}
