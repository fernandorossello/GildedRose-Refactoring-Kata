package com.gildedrose.quality;

import com.gildedrose.Item;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseUpdateStrategy implements QualityStrategy {

    protected List<QualityUpdateRule> rules = new ArrayList<>();

    @Override
    public final void update(Item item) {
        rules.forEach(r -> r.updateIfApplies(item));
    }
}
