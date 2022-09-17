package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.agecalculator.GreaterThan;
import com.gildedrose.quality.agecalculator.SmallerThan;
import com.gildedrose.quality.updater.QualityDecrement;
import java.util.ArrayList;
import java.util.List;

public class RegularDecreaseStrategy implements QualityStrategy {

    private final QualityUpdateRule decreaseByOneUntilOutdated = new QualityUpdateRule(
        new GreaterThan(-1), new QualityDecrement(1));
    private final QualityUpdateRule decreaseByTwoWhenOutdated = new QualityUpdateRule(
        new SmallerThan(0), new QualityDecrement(2));
    List<QualityUpdateRule> rules = new ArrayList<>();

    public RegularDecreaseStrategy() {
        rules.add(decreaseByOneUntilOutdated);
        rules.add(decreaseByTwoWhenOutdated);
    }

    @Override
    public void update(Item item) {
        rules.forEach(r -> r.updateIfApplies(item));
    }
}
