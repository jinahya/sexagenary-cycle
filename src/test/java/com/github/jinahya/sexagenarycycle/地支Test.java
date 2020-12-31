package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
@Slf4j
class 地支Test implements RollingEnumTest<地支> {

    static Set<地支> noneOf() {
        return EnumSet.noneOf(地支.class);
    }

    static Set<地支> allOf() {
        return EnumSet.allOf(地支.class);
    }

    // ----------------------------------------------------------------------------------------------------- REGEXP_NAME
    @DisplayName("REGEXP_NAME matches for each value's name")
    @Test
    void REGEXP_NAME_Match_ForEachValueName() {
        final Pattern pattern = Pattern.compile(地支.REGEXP_NAME);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // --------------------------------------------------------------------------------------------- valueOfName(String)
    @DisplayName("valueOfName(name) returns non-null and expected for each known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final String[] names = new String[] {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            assertThat(地支.valueOfName(name)).isNotNull().isSameAs(地支.valueOf(name));
            assertThat(地支.valueOfName(name).ordinal()).isSameAs(i);
        }
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @ValueSource(strings = {"", "愛"})
    @ParameterizedTest
    void valueOfName_IllegalArgumentException_NameIsUnknown(final String unknownName) {
        assertThrows(IllegalArgumentException.class, () -> 地支.valueOfName(unknownName));
    }

    // ------------------------------------------------------------------------------------------------------------ 二十四方
    @DisplayName("valueOf(二十四方) returns non-null and expected for each 二十四方 whose direction is divided by 30")
    @Test
    void valueOf二十四方_NonNullExpected_ForEach二十四方WhoseDirectionIsMultipleOf30() {
        final Set<地支> set = EnumSet.noneOf(地支.class);
        Arrays.stream(二十四方.values()).filter(d -> d.direction % 30 == 0).forEach(d -> {
            assertThat(地支.valueOf(d)).isNotNull().satisfies(v -> {
                assertThat(v.二十四方).isSameAs(d);
                assertThat(set.add(v)).isTrue();
            });
        });
        assertThat(set).isEqualTo(EnumSet.allOf(地支.class));
    }

    @DisplayName("二十四方 is non-null and direction is expected")
    @Test
    void 二十四方_NonNullHasExpectedDirection_ForEachValue() {
        assertThat(地支.子.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isZero());
        assertThat(地支.丑.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(30));
        assertThat(地支.寅.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(60));
        assertThat(地支.卯.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(90));
        assertThat(地支.辰.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(120));
        assertThat(地支.巳.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(150));
        assertThat(地支.午.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(180));
        assertThat(地支.未.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(210));
        assertThat(地支.申.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(240));
        assertThat(地支.酉.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(270));
        assertThat(地支.戌.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(300));
        assertThat(地支.亥.二十四方).isNotNull().satisfies(v -> assertThat(v.direction).isEqualTo(330));
    }

    // -------------------------------------------------------------------------------------------------------------- 五行
    @DisplayName("valuesOf(五行) returns non-null, non-empty and contains no nulls")
    @EnumSource(五行.class)
    @ParameterizedTest
    void valuesOf五行_NonNullNotEmptyNoNulls(final 五行 五行) {
        assertThat(地支.valuesOf(五行)).isNotNull().isNotEmpty().doesNotContainNull();
    }

    @DisplayName("valuesOf(五行) returns list contains expected in order")
    @Test
    void valuesOf五行_ContainsExpectedInOrder_ForEach五行() {
        final Set<地支> set = EnumSet.noneOf(地支.class);
        assertThat(地支.valuesOf(五行.木)).isNotNull().isNotEmpty().doesNotContainNull()
                .containsExactly(地支.寅, 地支.卯)
                .allSatisfy(v -> {
                    assertThat(set.add(v)).isTrue();
                });
        assertThat(地支.valuesOf(五行.火)).isNotNull().isNotEmpty().doesNotContainNull()
                .containsExactly(地支.巳, 地支.午)
                .allSatisfy(v -> {
                    assertThat(set.add(v)).isTrue();
                });
        assertThat(地支.valuesOf(五行.土)).isNotNull().isNotEmpty().doesNotContainNull()
                .containsExactly(地支.丑, 地支.辰, 地支.未, 地支.戌)
                .allSatisfy(v -> {
                    assertThat(set.add(v)).isTrue();
                });
        assertThat(地支.valuesOf(五行.金)).isNotNull().isNotEmpty().doesNotContainNull()
                .containsExactly(地支.申, 地支.酉)
                .allSatisfy(v -> {
                    assertThat(set.add(v)).isTrue();
                });
        assertThat(地支.valuesOf(五行.水)).isNotNull().isNotEmpty().doesNotContainNull()
                .containsExactly(地支.子, 地支.亥)
                .allSatisfy(v -> {
                    assertThat(set.add(v)).isTrue();
                });
        assertThat(set).isEqualTo(EnumSet.allOf(地支.class));
    }

    @Test
    void 五行_NonNullExpected_() {
        assertThat(地支.子.五行).isNotNull().isSameAs(五行.水);
        assertThat(地支.丑.五行).isNotNull().isSameAs(五行.土);
        assertThat(地支.寅.五行).isNotNull().isSameAs(五行.木);
        assertThat(地支.卯.五行).isNotNull().isSameAs(五行.木);
        assertThat(地支.辰.五行).isNotNull().isSameAs(五行.土);
        assertThat(地支.巳.五行).isNotNull().isSameAs(五行.火);
        assertThat(地支.午.五行).isNotNull().isSameAs(五行.火);
        assertThat(地支.未.五行).isNotNull().isSameAs(五行.土);
        assertThat(地支.申.五行).isNotNull().isSameAs(五行.金);
        assertThat(地支.酉.五行).isNotNull().isSameAs(五行.金);
        assertThat(地支.戌.五行).isNotNull().isSameAs(五行.土);
        assertThat(地支.亥.五行).isNotNull().isSameAs(五行.水);
    }

    // ------------------------------------------------------------------------------------------------------------- 時刻
    @Test
    void 時刻_NonNullExpected_() {
        assertThat(地支.子.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(23));
        assertThat(地支.丑.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(1));
        assertThat(地支.寅.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(3));
        assertThat(地支.卯.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(5));
        assertThat(地支.辰.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(7));
        assertThat(地支.巳.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(9));
        assertThat(地支.午.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(11));
        assertThat(地支.未.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(13));
        assertThat(地支.申.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(15));
        assertThat(地支.酉.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(17));
        assertThat(地支.戌.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(19));
        assertThat(地支.亥.時刻).isNotNull().satisfies(v -> assertThat(v.base.getHour()).isEqualTo(21));
    }

    // -------------------------------------------------------------------------------------------------------------- 月份
    @DisplayName("valueOf(Month) returns non-null for each Month")
    @EnumSource(Month.class)
    @ParameterizedTest
    void valueOfMonth_NonNull_ForEachMonth(final Month month) {
        assertThat(地支.valueOf(month)).isNotNull();
    }

    @DisplayName("valueOf(Month) returns full set of values for all Months")
    @Test
    void valueOfMonth_AllAssociated_ForAllMonth() {
        assertThat(Arrays.stream(Month.values()).map(地支::valueOf).collect(Collectors.toSet()))
                .isEqualTo(EnumSet.allOf(地支.class));
    }

    @DisplayName("all 月份 are non-null and expected")
    @Test
    void 月份_NonNullExpected_ForEachValue() {
        assertThat(地支.子.月份).isNotNull().isSameAs(Month.NOVEMBER);
        assertThat(地支.丑.月份).isNotNull().isSameAs(Month.DECEMBER);
        assertThat(地支.寅.月份).isNotNull().isSameAs(Month.JANUARY);
        assertThat(地支.卯.月份).isNotNull().isSameAs(Month.FEBRUARY);
        assertThat(地支.辰.月份).isNotNull().isSameAs(Month.MARCH);
        assertThat(地支.巳.月份).isNotNull().isSameAs(Month.APRIL);
        assertThat(地支.午.月份).isNotNull().isSameAs(Month.MAY);
        assertThat(地支.未.月份).isNotNull().isSameAs(Month.JUNE);
        assertThat(地支.申.月份).isNotNull().isSameAs(Month.JULY);
        assertThat(地支.酉.月份).isNotNull().isSameAs(Month.AUGUST);
        assertThat(地支.戌.月份).isNotNull().isSameAs(Month.SEPTEMBER);
        assertThat(地支.亥.月份).isNotNull().isSameAs(Month.OCTOBER);
    }

    // -------------------------------------------------------------------------------------------------------------- 陰陽
    @EnumSource(陰陽.class)
    @ParameterizedTest
    void valuesOf陰陽_NotEmpty_(final 陰陽 陰陽) {
        assertThat(地支.valuesOf(陰陽)).isNotEmpty().doesNotContainNull().hasSize(6);
    }

    @Test
    void 陰陽_NonNullExpected_ForEachValue() {
        assertThat(地支.子.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.丑.陰陽).isSameAs(陰陽.陰);
        assertThat(地支.寅.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.卯.陰陽).isSameAs(陰陽.陰);
        assertThat(地支.辰.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.巳.陰陽).isSameAs(陰陽.陰);
        assertThat(地支.午.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.未.陰陽).isSameAs(陰陽.陰);
        assertThat(地支.申.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.酉.陰陽).isSameAs(陰陽.陰);
        assertThat(地支.戌.陰陽).isSameAs(陰陽.陽);
        assertThat(地支.亥.陰陽).isSameAs(陰陽.陰);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @RepeatedTest(128)
    void includes_NonNull_ForAnyTime() {
        assertThat(地支.valueOf(TimeTestUtils.randomTime())).isNotNull();
    }
}