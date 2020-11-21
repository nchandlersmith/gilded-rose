package com.gildedrose.rule.calculatequality;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityImprovesTiered;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("squid:S5838")
class RuleCalculateQualityImprovesTieredTest {

    @ParameterizedTest(name="#{index} - tiered quality test with arguments = {0}, {1}, {2}")
    @MethodSource("tieredRuleSpecs")
    void run_tieredQuality(int sellIn, int startingQuality, int expectedQuality) {
        RuleCalculateQualityImprovesTiered rule  = new RuleCalculateQualityImprovesTiered();
        int actualQuality = rule.run(sellIn, startingQuality);
        assertEquals(expectedQuality, actualQuality);
    }

    private static Stream<Arguments> tieredRuleSpecs() {
        return Stream.of(
                whenSellInGreaterThan9_thenIncreaseQualityBy1(),
                whenSellingBetween5And9Inclusive_thenIncreaseQualityBy2(),
                whenSellInNotNegativeAndLessThan5Inclusive_thenIncreaseQualityBy3()
        );
    }

    private static Arguments whenSellInGreaterThan9_thenIncreaseQualityBy1() {
        return Arguments.arguments(10, 21, 22);
    }

    private static Arguments whenSellingBetween5And9Inclusive_thenIncreaseQualityBy2() {
        return Arguments.arguments(5, 21, 23);
    }

    private static Arguments whenSellInNotNegativeAndLessThan5Inclusive_thenIncreaseQualityBy3() {
        return Arguments.arguments(4, 21, 24);
    }

    @Test
    void isEqualToItself() {
        RuleCalculateQualityImprovesTiered rule = new RuleCalculateQualityImprovesTiered();

        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        RuleCalculateQualityImprovesTiered rule = new RuleCalculateQualityImprovesTiered();

        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void isNotEqualToObjectOfDifferentClass() {
        RuleCalculateQualityImprovesTiered rule = new RuleCalculateQualityImprovesTiered();

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("objecct from other class")).isFalse();
    }

    @Test
    void isEqualToAnotherRuleQualityImprovedTieredObject() {
        RuleCalculateQualityImprovesTiered rule1 = new RuleCalculateQualityImprovesTiered();
        RuleCalculateQualityImprovesTiered rule2 = new RuleCalculateQualityImprovesTiered();

        assertThat(rule1.equals(rule2)).isTrue();
    }

}