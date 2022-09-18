package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {


    @Test
    void agedBrie_whenNotOutdated_shouldIncreaseQualityByOne() {
        Item agedBrie = new Item("Aged Brie", 1, 0);
        GildedRose store = new GildedRose(new Item[]{agedBrie});

        store.updateQuality();

        assertEquals(1, agedBrie.quality);
    }

    @Test
    void agedBrie_whenOutdated_shouldIncreaseQualityByTwo() {
        Item agedBrie = new Item("Aged Brie", -1, 0);
        GildedRose store = new GildedRose(new Item[]{agedBrie});

        store.updateQuality();

        assertEquals(2, agedBrie.quality);
    }

    @Test
    void backstageTickets_whenOutdated_shouldHaveQualityZero() {
        Item tickets = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5);
        GildedRose store = new GildedRose(new Item[]{tickets});

        store.updateQuality();

        assertEquals(0, tickets.quality);
    }

    @Test
    void backstageTickets_whenOneDayLeft_shouldIncreaseQualityByThree() {
        Item tickets = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0);
        GildedRose store = new GildedRose(new Item[]{tickets});

        store.updateQuality();

        assertEquals(3, tickets.quality);
    }

    @Test
    void backstageTickets_when7DayLeft_shouldIncreaseQualityByTwo() {
        Item tickets = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 0);
        GildedRose store = new GildedRose(new Item[]{tickets});

        store.updateQuality();

        assertEquals(2, tickets.quality);
    }

    @Test
    void backstageTickets_when15DayLeft_shouldIncreaseQualityByOne() {
        Item tickets = new Item("Backstage passes to a Rolling stones concert", 15, 0);
        GildedRose store = new GildedRose(new Item[]{tickets});

        store.updateQuality();

        assertEquals(1, tickets.quality);
    }

    @Test
    void conjured_whenNotOutdated_shouldDecreaseQualityByTwo() {
        Item conjuredRing = new Item("Conjured ring", 2, 2);
        GildedRose store = new GildedRose(new Item[]{conjuredRing});

        store.updateQuality();

        assertEquals(0, conjuredRing.quality);
    }

    @Test
    void conjured_whenOutdated_shouldDecreaseQualityByFour() {
        Item conjuredRing = new Item("Conjured ring", -1, 4);
        GildedRose store = new GildedRose(new Item[]{conjuredRing});

        store.updateQuality();

        assertEquals(0, conjuredRing.quality);
    }

    @Test
    void sulfuras_shouldRemainTheSame() {
        Item sulfuras = new Item("Sulfuras", 5, 80);

        GildedRose store = new GildedRose(new Item[]{sulfuras});

        store.updateQuality();

        assertEquals(80, sulfuras.quality);
        assertEquals(5, sulfuras.sellIn);
    }

}
