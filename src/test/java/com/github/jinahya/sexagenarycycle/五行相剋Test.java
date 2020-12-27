package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class 五行相剋Test {

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
    @Test
    void valueOfSource_NonNullUnique_() {
        final Set<五行相剋> set = EnumSet.noneOf(五行相剋.class);
        for (final 五行 subjective : 五行.values()) {
            assertThat(五行相剋.valueOfSubjective(subjective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    @Test
    void valueOfTarget_NonNullUnique_() {
        final Set<五行相剋> set = EnumSet.noneOf(五行相剋.class);
        for (final 五行 objective : 五行.values()) {
            assertThat(五行相剋.valueOfObjective(objective)).isNotNull().satisfies(v -> {
                assertThat(set.add(v)).isTrue();
            });
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void valueOfSubjectiveInCounteractingCycle_NonNullExpected() {
        assertThat(五行相剋.valueOfSubjectiveInCounteractingCycle(五行.木)).isNotNull().isSameAs(五行相剋.金剋木);
        assertThat(五行相剋.valueOfSubjectiveInCounteractingCycle(五行.金)).isNotNull().isSameAs(五行相剋.火剋金);
        assertThat(五行相剋.valueOfSubjectiveInCounteractingCycle(五行.火)).isNotNull().isSameAs(五行相剋.水剋火);
        assertThat(五行相剋.valueOfSubjectiveInCounteractingCycle(五行.水)).isNotNull().isSameAs(五行相剋.土剋水);
        assertThat(五行相剋.valueOfSubjectiveInCounteractingCycle(五行.土)).isNotNull().isSameAs(五行相剋.木剋土);
    }

    @Test
    void valueOfObjectiveInCounteractingCycle_NonNullExpected() {
        assertThat(五行相剋.valueOfObjectiveInCounteractingCycle(五行.金)).isNotNull().isSameAs(五行相剋.金剋木);
        assertThat(五行相剋.valueOfObjectiveInCounteractingCycle(五行.火)).isNotNull().isSameAs(五行相剋.火剋金);
        assertThat(五行相剋.valueOfObjectiveInCounteractingCycle(五行.水)).isNotNull().isSameAs(五行相剋.水剋火);
        assertThat(五行相剋.valueOfObjectiveInCounteractingCycle(五行.土)).isNotNull().isSameAs(五行相剋.土剋水);
        assertThat(五行相剋.valueOfObjectiveInCounteractingCycle(五行.木)).isNotNull().isSameAs(五行相剋.木剋土);
    }
}