package com.gildedrose.quality.agecalculator;

public class Outdated implements AgeCalculator {

    @Override
    public boolean check(int daysLeft) {
        return daysLeft < 0;
    }
}
