package com.gildedrose.item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ConjuredItemTest {
    private final String CONJURED_ITEM = "conjured item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy2() {
        StoreItem conjuredItem = StoreItemFactory.createConjuredItem(CONJURED_ITEM, 1,10);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isEqualTo(8);
    }
    
    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellInBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 10);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.sellIn).isZero();
    }
    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy4() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 10);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isEqualTo(6);
    }
    
    @Test
    void update_whenSellInEquals0_thenDecreaseSellInBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 0, 10);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.sellIn).isEqualTo(-1);
    }
    
    @Test
    void update_whenSellInNegative_thenDecreaseSellInBy1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, -1, 10);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.sellIn).isEqualTo(-2);
    }

    @Test
    void givenCommonItemWith3QualityAnd1SellIn_whenUpdate_thenQualityEquals1() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, 1, 3);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isEqualTo(1);
    }
    
    @Test
    void update_whenSellInNegative_thenDecreaseQualityBy4() {
        ConjuredItem conjuredItem = new ConjuredItem(CONJURED_ITEM, -1, 4);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isZero();
    }

    private static Arguments sellInEquals1_startingQualityEquals1_finalQualityEquals0() {
        return Arguments.arguments(1,1);
    }

    private static Arguments sellInEquals0_startingQualityEquals3_finalQualityEquals0() {
        return Arguments.arguments(0, 3);
    }

    private static Arguments sellInEquals0_startingQualityEquals0_finalQualityEquals0() {
        return Arguments.arguments(0, 0);
    }

    @ParameterizedTest(name = "#{index} - sellin: {0} starting quality: {1} final quality equals 0")
    @MethodSource("generateArgumentsForTests")
    void paramTests(int sellIn, int quality) {
        ConjuredItem conjuredItem = new ConjuredItem("some conjured item", sellIn, quality);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isZero();

    }

    private static Stream<Arguments> generateArgumentsForTests() {
        return Stream.of(
                sellInEquals1_startingQualityEquals1_finalQualityEquals0(),
                sellInEquals0_startingQualityEquals3_finalQualityEquals0(),
                sellInEquals0_startingQualityEquals0_finalQualityEquals0()
        );
    }

}
