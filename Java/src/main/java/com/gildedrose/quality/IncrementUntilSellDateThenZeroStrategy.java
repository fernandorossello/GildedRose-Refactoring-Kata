package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.quality.agecalculator.GreaterThan;
import com.gildedrose.quality.agecalculator.NotOutdated;
import com.gildedrose.quality.agecalculator.Outdated;
import com.gildedrose.quality.updater.QualityIncrement;
import com.gildedrose.quality.updater.SetTo;
import java.util.ArrayList;
import java.util.List;

public class IncrementUntilSellDateThenZeroStrategy implements
    QualityStrategy {

    QualityUpdateRule setZeroWhenOutdated = new QualityUpdateRule(new Outdated(), new SetTo(0));
    QualityUpdateRule incrementUntilOutdated = new QualityUpdateRule(new NotOutdated(),
        new QualityIncrement(1));

    List<QualityUpdateRule> rules = new ArrayList<>();

    public IncrementUntilSellDateThenZeroStrategy() {
        rules.add(incrementUntilOutdated);
        rules.add(setZeroWhenOutdated);
    }

    @Override
    public void update(Item item) {
        rules.forEach(r -> r.updateIfApplies(item));
    }
}
