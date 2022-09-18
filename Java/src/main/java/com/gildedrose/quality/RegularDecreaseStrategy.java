package com.gildedrose.quality;

import com.gildedrose.quality.agecalculator.GreaterThan;
import com.gildedrose.quality.agecalculator.SmallerThan;
import com.gildedrose.quality.updater.QualityDecrement;

public class RegularDecreaseStrategy extends BaseUpdateStrategy {

    private final QualityUpdateRule decreaseByOneUntilOutdated = new QualityUpdateRule(
        new GreaterThan(-1), new QualityDecrement(1));
    private final QualityUpdateRule decreaseByTwoWhenOutdated = new QualityUpdateRule(
        new SmallerThan(0), new QualityDecrement(2));


    public RegularDecreaseStrategy() {
        rules.add(decreaseByOneUntilOutdated);
        rules.add(decreaseByTwoWhenOutdated);
    }
}
