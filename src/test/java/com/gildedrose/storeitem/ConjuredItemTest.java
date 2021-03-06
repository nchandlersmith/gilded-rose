package com.gildedrose.storeitem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ConjuredItemTest {
    private final String CONJURED_ITEM = "conjured item";

    @Test
    void updateQuality_whenSellInGreaterThan0_thenDecreaseQualityBy2() {
        StoreItem conjuredItem = StoreItemFactory.createConjuredItem(CONJURED_ITEM, 1,12);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isEqualTo(10);
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_whenExpired_degradeBy4")
    void updateQuality_whenExpiredDegradeBy4(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem conjuredItem = StoreItemFactory.createConjuredItem(CONJURED_ITEM, sellIn, startingQuality);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenExpired_degradeBy4() {
        int startingQuality = 12;
        int expectedQuality = 8;
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(0, startingQuality, expectedQuality),
                Arguments.arguments(-1, startingQuality, expectedQuality)
        );
    }

    @ParameterizedTest(name = "#{index} - startingSellIn: {0} expectedSellIn: {1}")
    @MethodSource("createArguments_sellInAlwaysDecrements")
    void updateQuality_sellInAlwaysDecrements(int startingSellIn, int expectedSellIn) {
        StoreItem conjuredItem = StoreItemFactory.createConjuredItem(CONJURED_ITEM, startingSellIn ,5);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.sellIn).isEqualTo(expectedSellIn);
    }

    private static Stream<Arguments> createArguments_sellInAlwaysDecrements() {
        return Stream.of(
                // startingSellIn, expectedSellIn
                Arguments.arguments(1, 0),
                Arguments.arguments(0, -1),
                Arguments.arguments(-1, -2)
        );
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} starting quality: {1} final quality equals 0")
    @MethodSource("createArguments_qualityCannotBeLessThan0Tests")
    void updateQuality_qualityCannotBeLessThan0(int sellIn, int quality) {
        StoreItem conjuredItem = StoreItemFactory.createConjuredItem(CONJURED_ITEM, sellIn, quality);
        conjuredItem.updateQuality();
        assertThat(conjuredItem.quality).isZero();

    }

    private static Stream<Arguments> createArguments_qualityCannotBeLessThan0Tests() {
        return Stream.of(
                // sellIn, startingQuality
                Arguments.arguments(1, 1),
                Arguments.arguments(0, 3),
                Arguments.arguments(0, 0)
        );
    }
}
