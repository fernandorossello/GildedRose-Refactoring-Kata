package com.gildedrose.quality.agecalculator;

public class GreaterThan implements AgeCalculator {

    private final int limit;

    public GreaterThan(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean check(int daysLeft) {
        return daysLeft > limit;
    }
}
