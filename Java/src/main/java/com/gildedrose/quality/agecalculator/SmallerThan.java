package com.gildedrose.quality.agecalculator;

public class SmallerThan implements AgeCalculator {

    private final int limit;

    public SmallerThan(int limit) {
        this.limit = limit;
    }

  @Override
    public boolean check(int daysLeft) {
        return daysLeft < limit;
    }
}
