package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConjuredItemTest {
    private final String CONJURED_ITEM = "conjured item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy2() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 10);
        
        conjuredItem.updateQuality();

        assertEquals(8, conjuredItem.quality);
    }
    
    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellinBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 10);
        
        conjuredItem.updateQuality();

        assertEquals(0, conjuredItem.sellIn);
    }
    
    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy4() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 10);
        
        conjuredItem.updateQuality();

        assertEquals(6, conjuredItem.quality);
    }
    
    @Test
    void update_whenSellInEquals0_thenDecreaseSellinBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 10);
        
        conjuredItem.updateQuality();

        assertEquals(-1, conjuredItem.sellIn);
    }
    
    @Test
    void update_whenSellInNegative_thenDecreaseSellinBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, -1, 10);
        
        conjuredItem.updateQuality();

        assertEquals(-2, conjuredItem.sellIn);
    }
    
    @Test
    void update_whenSellInNegative_thenDecreaseQualityBy4() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, -1, 10);
        
        conjuredItem.updateQuality();

        assertEquals(6, conjuredItem.quality);
    }
    
    @Test
    void givenCommonItemWith0QualityAnd0SellIn_whenUpdate_thenQualityRemains0() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 0);
        
        conjuredItem.updateQuality();

        assertEquals(0, conjuredItem.quality);
    }
    
    @Test
    void givenCommonItemWith1QualityAnd1SellIn_whenUpdate_thenQualityEquals0() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 1);
        
        conjuredItem.updateQuality();

        assertEquals(0, conjuredItem.quality);
    }
    
    @Test
    void givenCommonItemWith3QualityAnd0SellIn_whenUpdate_thenQualityEquals0() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 3);
        
        conjuredItem.updateQuality();

        assertEquals(0, conjuredItem.quality);
    }
    
    @Test
    void givenCommonItemWith3QualityAnd1SellIn_whenUpdate_thenQualityEquals1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 3);
        
        conjuredItem.updateQuality();

        assertEquals(1, conjuredItem.quality);
    }
}
