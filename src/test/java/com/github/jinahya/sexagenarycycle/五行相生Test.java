package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class 五行相生Test {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void fieldSubjective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相生 value : 五行相生.values()) {
            assertThat(set.add(value.subjective)).isTrue();
        }
    }

    @Test
    void fieldObjective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相生 value : 五行相生.values()) {
            assertThat(set.add(value.objective)).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOfSource_NonNullUnique_() {
        final Set<五行相生> set = EnumSet.noneOf(五行相生.class);
        for (final 五行 subjective : 五行.values()) {
            assertThat(五行相生.valueOfSubjective(subjective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    @Test
    void valueOfTarget_NonNullUnique_() {
        final Set<五行相生> set = EnumSet.noneOf(五行相生.class);
        for (final 五行 objective : 五行.values()) {
            assertThat(五行相生.valueOfObjective(objective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }
}