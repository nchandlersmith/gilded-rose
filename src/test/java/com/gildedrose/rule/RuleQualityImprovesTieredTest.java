package com.gildedrose.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualityImprovesTieredTest {

    @ParameterizedTest(name="#{index} - tiered quality test with arguments = {0}, {1}, {2}")
    @MethodSource("tieredRuleSpecs")
    void run_tieredQuality(int sellIn, int startingQuality, int expectedQuality) {
        RuleQualityImprovesTiered rule  = new RuleQualityImprovesTiered();
        int actualQuality = rule.run(sellIn, startingQuality);
        assertEquals(expectedQuality, actualQuality);
    }

    static Stream<Arguments> tieredRuleSpecs() {
        return Stream.of(
                Arguments.arguments(11, 21, 22), // sellIn > 10
                Arguments.arguments(10, 21, 23), // 5 < sellIn < 11
                Arguments.arguments(5, 21, 24) // -1 < sellIn < 6
        );
    }
}