package com.gildedrose;

class GildedRose {

    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementQuality(item);
                    }
                }
            } else {
                if (canIncreaseQuality(item)) {
                    incrementQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            incrementQualityIfPossible(item);

                            if (item.sellIn < 6) {
                                incrementQualityIfPossible(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (isOutdated(item)) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementQuality(item);
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    incrementQualityIfPossible(item);
                }
            }
        }
    }

    private void incrementQualityIfPossible(Item item) {
        if (canIncreaseQuality(item)) {
            incrementQuality(item);
        }
    }

    private boolean isOutdated(Item item) {
        return item.sellIn < 0;
    }

    private void decrementQuality(Item item) {
        item.quality--;
    }

    private void incrementQuality(Item item) {
        item.quality++;
    }

    private boolean canIncreaseQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }
}
