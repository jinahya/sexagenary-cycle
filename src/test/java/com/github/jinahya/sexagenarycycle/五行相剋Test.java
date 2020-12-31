package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五行相剋Test implements RollingEnumTest<五行相剋> {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void fieldSubjective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相剋 value : 五行相剋.values()) {
            assertThat(set.add(value.subjective)).isTrue();
        }
    }

    @Test
    void fieldObjective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相剋 value : 五行相剋.values()) {
            assertThat(set.add(value.objective)).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfSubjective(五行) returns non-null and unique for each 五行")
    @Test
    void valueOfSubjective_NonNullUnique_ForEach五行() {
        final Set<五行相剋> set = EnumSet.noneOf(五行相剋.class);
        for (final 五行 subjective : 五行.values()) {
            assertThat(五行相剋.valueOfSubjective(subjective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfObjective(五行) returns non-null and unique for each 五行")
    @Test
    void valueOfObjective_NonNullUnique_ForEach五行() {
        final Set<五行相剋> set = EnumSet.noneOf(五行相剋.class);
        for (final 五行 objective : 五行.values()) {
            assertThat(五行相剋.valueOfObjective(objective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }
}