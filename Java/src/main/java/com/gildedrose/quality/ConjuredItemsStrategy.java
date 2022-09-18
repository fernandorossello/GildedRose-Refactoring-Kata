package com.gildedrose.quality;

import com.gildedrose.quality.agecalculator.NotOutdated;
import com.gildedrose.quality.agecalculator.Outdated;
import com.gildedrose.quality.updater.QualityDecrement;

public class ConjuredItemsStrategy extends BaseUpdateStrategy {

    QualityUpdateRule whenNotOutdatedDecreaseQualityByTwo = new QualityUpdateRule(new NotOutdated(),new QualityDecrement(2));
    QualityUpdateRule whenOutdatedDecrementQualityByFour = new QualityUpdateRule(new Outdated(),new QualityDecrement(4));


    public ConjuredItemsStrategy(){
        rules.add(whenNotOutdatedDecreaseQualityByTwo);
        rules.add(whenOutdatedDecrementQualityByFour);
    }
}
