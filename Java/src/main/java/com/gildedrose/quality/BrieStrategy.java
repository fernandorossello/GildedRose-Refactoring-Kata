package com.gildedrose.quality;

import com.gildedrose.quality.agecalculator.NotOutdated;
import com.gildedrose.quality.agecalculator.Outdated;
import com.gildedrose.quality.updater.QualityIncrement;

public class BrieStrategy extends BaseUpdateStrategy{

    private final QualityUpdateRule increaseUntilOutdated = new QualityUpdateRule(new NotOutdated(),
        new QualityIncrement(1));
    private final QualityUpdateRule increaseByTwoWhenOutdated = new QualityUpdateRule(new Outdated(),
        new QualityIncrement(2));

    public BrieStrategy(){
        rules.add(increaseUntilOutdated);
        rules.add(increaseByTwoWhenOutdated);
    }
}
