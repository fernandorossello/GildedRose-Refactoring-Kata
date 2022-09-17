package com.gildedrose.quality.agecalculator;

public class Between implements AgeCalculator{


    private final int inclusiveTo;
    private final int inclusiveFrom;

    public Between(int inclusiveFrom, int inclusiveTo ){
        this.inclusiveFrom = inclusiveFrom;
        this.inclusiveTo = inclusiveTo;
    }

    @Override
    public boolean check(int daysLeft) {
        return daysLeft >= inclusiveFrom && daysLeft <= inclusiveTo;
    }
}
