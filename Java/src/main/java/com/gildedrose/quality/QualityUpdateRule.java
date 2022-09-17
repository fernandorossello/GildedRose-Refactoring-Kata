package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.agecalculator.AgeCalculator;
import com.gildedrose.quality.updater.QualityUpdater;

public class QualityUpdateRule {

    private final AgeCalculator ageCalculator;
    private final QualityUpdater qualityUpdater;

    public QualityUpdateRule(AgeCalculator ageCalculator, QualityUpdater qualityUpdater) {
        this.ageCalculator = ageCalculator;
        this.qualityUpdater = qualityUpdater;
    }

    public void updateIfApplies(Item item) {
        if (ageCalculator.check(item.sellIn)) {
            qualityUpdater.update(item);
        }
    }
}
