package com.gildedrose.quality.agecalculator;

public class NotOutdated implements AgeCalculator {

    @Override
    public boolean check(int daysLeft) {
        return !new Outdated().check(daysLeft);
    }
}
