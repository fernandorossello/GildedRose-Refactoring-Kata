package com.gildedrose.quality;

import com.gildedrose.quality.agecalculator.Between;
import com.gildedrose.quality.agecalculator.GreaterThan;
import com.gildedrose.quality.agecalculator.Outdated;
import com.gildedrose.quality.updater.QualityIncrement;
import com.gildedrose.quality.updater.SetTo;

public class BackstageTicketsStrategy extends BaseUpdateStrategy {

    QualityUpdateRule rule1 = new QualityUpdateRule(new GreaterThan(10), new QualityIncrement(1));
    QualityUpdateRule rule2 = new QualityUpdateRule(new Between(6, 10),
        new QualityIncrement(2));
    QualityUpdateRule rule3 = new QualityUpdateRule(new Between(0, 5),
        new QualityIncrement(3));
    QualityUpdateRule setZeroWhenOutdated = new QualityUpdateRule(new Outdated(), new SetTo(0));

    public BackstageTicketsStrategy() {
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(setZeroWhenOutdated);
    }
}
