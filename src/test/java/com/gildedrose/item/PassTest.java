package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PassTest {

    private final String PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void givenPassesWithSellInGreaterThan10_whenUpdate_thenIncreaseQualityBy1() {
        Pass pass = new Pass(PASSES, 11, 20);

        pass.updateQuality();

        assertEquals(21, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInEquals10_whenUpdate_thenIncreaseQualityBy2() {
        Pass pass = new Pass(PASSES, 10, 20);

        pass.updateQuality();

        assertEquals(22, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInAtOrBetween6And10_whenUpdate_thenIncreaseQualityBy2() {
        Pass pass = new Pass(PASSES, 6, 20);

        pass.updateQuality();

        assertEquals(22, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInEquals5_whenUpdate_thenIncreaseQualityBy3() {
        Pass pass = new Pass(PASSES, 5, 20);

        pass.updateQuality();

        assertEquals(23, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInAtOrBetween1And5_whenUpdate_thenIncreaseQualityBy3() {
        Pass pass = new Pass(PASSES, 1, 20);

        pass.updateQuality();

        assertEquals(23, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInEquals0_whenUpdate_thenQualityEquals0() {
        Pass pass = new Pass(PASSES, 0, 20);

        pass.updateQuality();

        assertEquals(0, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInLessThan0_whenUpdate_thenQualityEquals0() {
        Pass pass = new Pass(PASSES, -1, 20);

        pass.updateQuality();

        assertEquals(0, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInEquals0_whenUpdate_thenSellInDecrements() {
        Pass pass = new Pass(PASSES, 0, 20);

        pass.updateQuality();

        assertEquals(-1, pass.sellIn);
    }
    
    @Test
    void givenPassesWithSellInEqualsNegative1_whenUpdate_thenSellInDecrements() {
        Pass pass = new Pass(PASSES, -1, 20);

        pass.updateQuality();

        assertEquals(-2, pass.sellIn);
    }
    
    @Test
    void givenPassesWithSellInGreaterThan10_whenUpdate_thenQualityMaxesAt50() {
        Pass pass = new Pass(PASSES, 11, 50);

        pass.updateQuality();

        assertEquals(50, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInAtOrBetween6And10_whenUpdate_thenQualityMaxesAt50() {
        Pass pass = new Pass(PASSES, 10, 50);

        pass.updateQuality();

        assertEquals(50, pass.quality);
    }
    
    @Test
    void givenPassesWithSellInBetween0And6_whenUpdate_thenQualityMaxesAt50() {
        Pass pass = new Pass(PASSES, 5, 50);

        pass.updateQuality();

        assertEquals(50, pass.quality);
    }
}
