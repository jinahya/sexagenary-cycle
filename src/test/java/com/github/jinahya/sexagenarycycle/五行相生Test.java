package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五行相生Test implements RollingEnumTest<五行相生> {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void subjective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相生 value : 五行相生.values()) {
            assertThat(set.add(value.subjective)).isTrue();
        }
    }

    @Test
    void objective_Unique_EachOther() {
        final Set<五行> set = EnumSet.noneOf(五行.class);
        for (final 五行相生 value : 五行相生.values()) {
            assertThat(set.add(value.objective)).isTrue();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOfSubjective_NonNullUnique_() {
        final Set<五行相生> set = EnumSet.noneOf(五行相生.class);
        for (final 五行 subjective : 五行.values()) {
            assertThat(五行相生.valueOfSubjective(subjective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    @Test
    void valueOfObjective_NonNullUnique_() {
        final Set<五行相生> set = EnumSet.noneOf(五行相生.class);
        for (final 五行 objective : 五行.values()) {
            assertThat(五行相生.valueOfObjective(objective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfSubjectiveInWeakeningCycle(五行) returns non-null and same as getValueOfObjective(五行)")
    @EnumSource(五行.class)
    @ParameterizedTest
    void valueOfSubjectiveInWeakeningCycle_NonNullSameAsValueOfObjective_ForEach五行(final 五行 五行) {
        assertThat(五行相生.valueOfSubjectiveInWeakeningCycle(五行)).isNotNull().isSameAs(五行相生.valueOfObjective(五行));
    }

    @DisplayName("valueOfObjectiveInWeakeningCycle(五行) returns non-null and same as getValueOfSubjective(五行)")
    @EnumSource(五行.class)
    @ParameterizedTest
    void valueOfObjectiveInWeakeningCycle_NonNullSameAsValueOfSubjective_ForEach五行(final 五行 五行) {
        assertThat(五行相生.valueOfObjectiveInWeakeningCycle(五行)).isNotNull().isSameAs(五行相生.valueOfSubjective(五行));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getPreviousInWeakeningCycle() returns non-null and same as getNext()")
    @EnumSource(五行相生.class)
    @ParameterizedTest
    void getPreviousInWeakeningCycle_NonNullSameAsNext_ForEachValue(final 五行相生 value) {
        assertThat(value.getPreviousInWeakeningCycle()).isNotNull().isSameAs(value.getNext());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("getNextInWeakeningCycle() returns non-null and same as getPrevious()")
    @EnumSource(五行相生.class)
    @ParameterizedTest
    void getNextInWeakeningCycle__NonNullSameAsPrevious_ForEachValue(final 五行相生 value) {
        assertThat(value.getNextInWeakeningCycle()).isNotNull().isSameAs(value.getPrevious());
    }
}