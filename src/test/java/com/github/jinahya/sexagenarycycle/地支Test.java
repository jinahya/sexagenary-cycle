package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 地支Test {

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("REGEXP_NAME matches for every value's name")
    @Test
    void REGEXP_NAME_Match_EveryName() {
        final Pattern pattern = Pattern.compile(地支.REGEXP_NAME);
        for (final 地支 value : 地支.values()) {
            assertThat(pattern.matcher(value.name()).matches()).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOf(name) returns valid value for known name")
    @Test
    void valueOfName_ExpectedResult_NameIsKnown() {
        final String[] names = new String[] {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        for (int i = 0; i < names.length; i++) {
            final String name = names[i];
            assertThat(地支.ofName(name)).isNotNull().isSameAs(地支.valueOf(name));
            assertThat(地支.ofName(name).ordinal()).isSameAs(i);
        }
    }

    @DisplayName("valueOfName(name) throws IllegalArgumentException when name is unknown")
    @Test
    void valueOfName_IllegalArgumentException_NameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> 地支.ofName(""));
    }

    // ----------------------------------------------------------------------------------------------------------- get五行
    @Test
    void get五行_NonNull() {
        for (final 地支 value : 地支.values()) {
            assertThat(value.get五行()).isNotNull();
        }
    }

    // ----------------------------------------------------------------------------------------------------------- get陰陽
    @Test
    void get陰陽_NonNull() {
        for (final 地支 value : 地支.values()) {
            assertThat(value.get陰陽()).isNotNull();
        }
    }

    // --------------------------------------------------------------------------------------------------------- get二十四方
    @Test
    void get二十四方_NonNullOrdinalTimes30() {
        for (final 地支 value : 地支.values()) {
            assertThat(value.get二十四方()).isNotNull().satisfies(v -> {
                assertThat(v.direction).isEqualTo(value.ordinal() * 30);
            });
        }
    }

    // ----------------------------------------------------------------------------------------------------------- get月份
    @Test
    void get月份_NonNullUnique() {
        final Set<Month> set = EnumSet.noneOf(Month.class);
        for (final 地支 value : 地支.values()) {
            assertThat(value.get月份()).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getPrevious() returns expected value")
    @Test
    void getPrevious_ExpectedResult() {
        final Set<地支> all = EnumSet.allOf(地支.class);
        for (final 地支 each : all) {
            assertThat(each.getPrevious()).isNotNull().isNotSameAs(each)
                    .satisfies(p -> {
                        assertThat(p.getNext()).isNotNull().isSameAs(each);
                        assertThat(p.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isSameAs(all.size() - 1),
                                o -> assertThat(o).isSameAs(each.ordinal() - 1)
                        );
                    });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getNext() returns expected value")
    @Test
    void getNext_ExpectedResult() {
        final Set<地支> all = EnumSet.allOf(地支.class);
        for (final 地支 each : all) {
            assertThat(each.getNext()).isNotNull().isNotSameAs(each)
                    .satisfies(n -> {
                        assertThat(n.getPrevious()).isNotNull().isSameAs(each);
                        assertThat(n.ordinal()).satisfiesAnyOf(
                                o -> assertThat(o).isZero(),
                                o -> assertThat(o).isSameAs(each.ordinal() + 1)
                        );
                    });
        }
    }
}