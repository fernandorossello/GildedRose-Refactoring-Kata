package com.gildedrose.quality;

import com.gildedrose.quality.agecalculator.NotOutdated;
import com.gildedrose.quality.agecalculator.Outdated;
import com.gildedrose.quality.updater.QualityIncrement;
import com.gildedrose.quality.updater.SetTo;

public class IncrementUntilSellDateThenZeroStrategy extends BaseUpdateStrategy {

    QualityUpdateRule setZeroWhenOutdated = new QualityUpdateRule(new Outdated(), new SetTo(0));
    QualityUpdateRule incrementUntilOutdated = new QualityUpdateRule(new NotOutdated(),
        new QualityIncrement(1));

    public IncrementUntilSellDateThenZeroStrategy() {
        rules.add(incrementUntilOutdated);
        rules.add(setZeroWhenOutdated);
    }
}
