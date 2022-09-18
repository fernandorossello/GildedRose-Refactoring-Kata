package com.gildedrose.quality;

import com.gildedrose.Item;
import java.util.Locale;

public class QualityStrategyFactory {

    public static QualityStrategy get(Item item) {
        if (itemIs("Sulfuras", item)) {
            return new NoOpQualityStrategy();
        }

        if (itemIs("Aged brie", item)) {
            return new BrieStrategy();
        }

        if (itemIs("Backstage passes", item)) {
            return new BackstageTicketsStrategy();
        }

        if (itemIs("Conjured", item)) {
            return new ConjuredItemsStrategy();
        }

        return new RegularDecreaseStrategy();
    }

    private static boolean itemIs(String name, Item item) {
        Locale locale = Locale.ROOT;
        return item.name.toLowerCase(locale)
            .startsWith(name.toLowerCase(locale));
    }

}
