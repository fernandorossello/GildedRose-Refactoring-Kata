package com.gildedrose.quality;

import com.gildedrose.Item;

public class QualityStrategyFactory {

    public static QualityStrategy get(Item item){
        if(item.name.startsWith("Sulfuras")) {
            return new NoOpQualityStrategy();
        }

        if(item.name.startsWith("Backstage passes")) {
            return new BackstageTicketsStrategy();
        }

        return new RegularDecreaseStrategy();
    }

}
