package com.gildedrose.storeitem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AgedBrieTest {

    private final String AGED_BRIE = "Aged Brie";

    @Test
    void updateQuality_whenNotExpired_incrementsQuality() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, 5, 20);
        agedBrie.updateQuality();
        assertThat(agedBrie.quality).isEqualTo(21);
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality{2}")
    @MethodSource("createArguments_whenExpired_increaseQualityBy2")
    void updateQuality_whenExpired_increaseQualityBy2(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, sellIn, startingQuality);
        agedBrie.updateQuality();
        assertThat(agedBrie.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenExpired_increaseQualityBy2() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(0, 20, 22),
                Arguments.arguments(-1, 20, 22)
        );
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_qualityCannotBeGreaterThan50")
    void updateQuality_qualityCannotBeGreaterThan50(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, sellIn, startingQuality);
        agedBrie.updateQuality();
        assertThat(agedBrie.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_qualityCannotBeGreaterThan50() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(1, 50, 50),
                Arguments.arguments(0, 50, 50),
                Arguments.arguments(-1, 50, 50)
        );
    }

    @ParameterizedTest(name = "#{index} - startingSellIn: {0} expectedSellIn: {1}")
    @MethodSource("createArguments_sellInAlwaysDecrements")
    void updateQuality_sellInAlwaysDecrements(int startingSellIn, int expectedSellIn) {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, startingSellIn, 12);
        agedBrie.updateQuality();
        assertThat(agedBrie.sellIn).isEqualTo(expectedSellIn);
    }

    private static Stream<Arguments> createArguments_sellInAlwaysDecrements() {
        return Stream.of(
                // startingSellIn, expectedSellIn
                Arguments.arguments(1, 0),
                Arguments.arguments(0, -1),
                Arguments.arguments(-1, -2)
        );
    }
}
